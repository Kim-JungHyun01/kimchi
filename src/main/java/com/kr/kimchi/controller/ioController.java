package com.kr.kimchi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kr.kimchi.service.informationService;
import com.kr.kimchi.vo.IOVO;
import com.kr.kimchi.vo.IemailVo;
import com.kr.kimchi.vo.InlistVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.PaPageVO;
import com.kr.kimchi.vo.StatusCheck;
import com.kr.kimchi.vo.inPageLIst;
import com.kr.kimchi.vo.transactionVO;

@Controller
public class ioController {
	
	@Inject
	informationService service;

	private static final Logger logger = LoggerFactory.getLogger(ioController.class);
	
	@RequestMapping(value="information", method = RequestMethod.GET)
	public ModelAndView io_imformation(@RequestParam(defaultValue = "1") int pageNum) {
		ModelAndView mav = new ModelAndView();
		List<ObtainVO> list= service.modar_data();
		List<InlistVO> in_list=service.in_select();
		
		PaPageVO pageVO = new PaPageVO(pageNum, in_list.size());
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageVO.getPageNum() - 1) * pageVO.getListcnt());
		params.put("count", pageVO.getListcnt());
		
		
		List<InlistVO> pageAllList = service.pa_select(params); // ÆäÀÌÂ¡ ¸®½ºÆ®
		
		inPageLIst in = new inPageLIst(pageAllList,pageVO);
//		System.out.println(in);
		
		//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		int startIndex = (in.getPageVO().getPageNum() - 1) * in.getPageVO().getListcnt() + 1;
		
		
		mav.addObject("startIndex", startIndex);
		mav.addObject("in", in);
		mav.addObject("list", list);
		
		
		
		mav.setViewName("io/information");
		
		return mav;
	}//end
	
	@RequestMapping(value="inselect", method = RequestMethod.GET)
	public ModelAndView inselect(@RequestParam(defaultValue = "1") int pageNum,
								@RequestParam(required = false) String io_status,
								@RequestParam(required = false) String partner_companyname) {
		ModelAndView mav = new ModelAndView();
		List<ObtainVO> list= service.modar_data();
		List<InlistVO> in_list=service.in_select();
		
		PaPageVO pageVO = new PaPageVO(pageNum, in_list.size());
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageVO.getPageNum() - 1) * pageVO.getListcnt());
		params.put("count", pageVO.getListcnt());
		params.put("io_status", io_status);
		params.put("partner_companyname", partner_companyname);
		
		
		List<InlistVO> pageAllList = service.pa_select(params); // ÆäÀÌÂ¡ ¸®½ºÆ®
//		System.out.println("inselect : "+pageAllList);
		
		inPageLIst in = new inPageLIst(pageAllList,pageVO);
//		System.out.println("inselect : "+in);
		
		//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		int startIndex = (in.getPageVO().getPageNum() - 1) * in.getPageVO().getListcnt() + 1;
		
		
		mav.addObject("startIndex", startIndex);
		mav.addObject("in", in);
		mav.addObject("list", list);
		
		
		
		mav.setViewName("io/information");
		
		return mav;
	}//end
	
	
	
	@PostMapping(value = "insert_io")
	public String IN_io_imformation(IOVO vo, RedirectAttributes rttr) {
	    
		vo.setIo_status("ÀÔ°íÁß");
	    
	    System.out.println(vo);

	    int obtain_no = vo.getObtain_no();
	    System.out.println(obtain_no);

	    int result = service.in_add(vo);
	    int result2 = service.in_update_ob(obtain_no);

	    if (result > 0 && result2 > 0) {
	        rttr.addFlashAttribute("msg", "success");
	    }

	    return "redirect:/information"; 
	}
	
	@PostMapping("io_status_ch")
	public String handleFormSubmit(@RequestParam(value = "iocheck", required = false) List<String> iocheck, RedirectAttributes rttr) {
	    List<StatusCheck> dataList = new ArrayList<>();
	    
	    if (iocheck != null) {
	        for (String item : iocheck) {
	            try {
	                String[] parts = item.split(",");
	                if (parts.length == 5) {
	                    StatusCheck dataObject = new StatusCheck();
	                    dataObject.setIo_id(parseInteger(parts[0]));
	                    dataObject.setObtain_no(parseInteger(parts[1]));
	                    dataObject.setIo_status(parts[2]);
	                    dataObject.setIo_quantity(parseInteger(parts[3]));
	                    dataObject.setMa_id(parseInteger(parts[4]));
	                    dataList.add(dataObject);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                rttr.addFlashAttribute("msg", "hu");
	                return "redirect:/information";
	            }
	        }
	    }

	    System.out.println("------" + dataList);

	    for (StatusCheck statusCheck : dataList) {
	        int status_done = service.io_status_change(statusCheck.getIo_id());
	        int material_plus = service.material_io(statusCheck);
	        
	        IemailVo data = service.email_serch(statusCheck.getObtain_no());
	        System.out.println(data);
	        // null Ã¼Å© Ãß°¡
	        if (data != null) {
	            sendEmail3(data.getMa_name(), data.getObtain_no(), data.getUser_email());
	        } else {
	            rttr.addFlashAttribute("msg", "Email data not found for obtain_no: " + statusCheck.getObtain_no());
	            return "redirect:/information";
	        }
	        
	        if (status_done < 0 || material_plus < 0) {
	            rttr.addFlashAttribute("msg", "hu");
	            return "redirect:/information";
	        }
	    }
	    
	    rttr.addFlashAttribute("msg", "success");
	    return "redirect:/information";
	}

	private Integer parseInteger(String value) {
	    try {
	        return value == null || value.isEmpty() ? null : Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        return null;
	    }
	}

	
	@GetMapping(value = "transaction")
    public String transaction(@RequestParam(value = "obtain_no", required = false)  String obtainNo,
                              RedirectAttributes rttr, Model model) {

		  if (obtainNo != null) {
		        try {
		            Integer obtainNoInt = parseInteger(obtainNo);
		            StatusCheck dataObject = new StatusCheck();
		            dataObject.setObtain_no(obtainNoInt);
		            
		            // ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ Ã³ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		            transactionVO statement = service.transaction_statement(obtainNoInt);
		            System.out.println(statement);
		            model.addAttribute("value", statement);

		            // ï¿½ï¿½È¯ï¿½Ï´ï¿½ ï¿½ï¿½ ï¿½Ì¸ï¿½
		            return "/io/transaction";
		        } catch (Exception e) {
		            e.printStackTrace();
		            // ï¿½ï¿½ï¿½ï¿½ Ã³ï¿½ï¿½
		            return "/error";
		        }
		    }

		    return "/error"; // ï¿½ß¸ï¿½ï¿½ï¿½ ï¿½ï¿½Ã» Ã³ï¿½ï¿½
    }

    private Integer parseIntegers(String value) {
        try {
            return value == null || value.isEmpty() ? null : Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½È¯ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ nullï¿½ï¿½ ï¿½ï¿½È¯
            return null;
        }
    }
		
	    
	
	public static void sendEmail3(String ma_name,int obtain_no,String receivedMail) {
		// ±¸±Û ÀÌ¸ÞÀÏ
		String user_email= "jae1hyun31@gmail.com";
		// ±¸±Û ºñ¹ø
		String user_pw = "ppjd pgrx jzhe geng";
		
		String smtp_host = "smtp.gmail.com";
		int smtp_port = 465;  // TLS : 587, SSL : 465
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtp_host); 
		props.put("mail.smtp.port", smtp_port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", smtp_host);
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user_email, user_pw);
			}
		});
		
		try {
			receivedMail="jae1hyun31@gmail.com";
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user_email));
			
			// ¹Þ´Â ÀÌ¸ÞÀÏ
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(receivedMail)    
					);
			
			// Á¦¸ñ
			message.setSubject("ÀÔ°í °ü·Ã ¸ÞÀÏÀÔ´Ï´Ù."); 
			
			// ³»¿ë
			message.setText(
					"¾È³çÇÏ¼¼¿ä. (ÁÖ)»ï±è½ÅÁ¶ÀÔ´Ï´Ù. \n"+
							"ÄÚµå ob-"+obtain_no+" Á¶´Þ¹øÈ£ÀÎ "+"ÀÚÀç "+ma_name+"¿¡ "
							+ "ÀÔ°í°¡ ¿Ï·áµÇ¾î¼­ ¸ÞÀÏ ¹ß¼Ûµå¸³´Ï´Ù. \n");
			
			// ¹ß¼Û
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
		
	}
		
		
	
	
	

