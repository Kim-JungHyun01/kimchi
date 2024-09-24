package com.kr.kimchi;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailSend {
	
	//자회사
	@ResponseBody
	@PostMapping(value="pa/mail")
	public void mail(@RequestParam("date") String date, @RequestParam("partner") String partner,@RequestParam("receivedMail") String receivedMail) {
		sendEmail(date, partner,receivedMail);
	}

	@ResponseBody
	@PostMapping(value="pa/mail2")
	public void mail2(@RequestParam("date") String date, @RequestParam("notes") String notes,@RequestParam("receivedMail") String receivedMail) {
		sendEmail2(date, notes,receivedMail);
	}

	@PostMapping(value="/mail3")
	public ModelAndView mail3(@RequestParam("receivedMail") String receivedMail) {
		ModelAndView mav = new ModelAndView();
		sendEmail3(receivedMail);
		mav.setViewName("redirecet:information");
		return mav;
	}
	
	public static void sendEmail(String date, String parthner, String receivedMail) {
		// 구글 이메일
		String user_email= "dohyun9160@gmail.com";
		// 구글 비번
		String user_pw = "lxrd avnm mucs wtds";
		
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

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(user_email));

	           // 받는 이메일
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(receivedMail)    
	            );
		
		  // 제목
	            message.setSubject("진척검수일정 관련 메일입니다."); 
		  
		   // 내용
	            message.setText(
	            		"안녕하세요. (주)삼김신조입니다. \n"
	            		+ date + "의 검수일정이 잡혔습니다. \n"
	            		+ " \n"
	            		+ parthner +"의 검수 일정이니 확인부탁드립니다.\n");

	            // 발송
	            Transport.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	    }
	
	public static void sendEmail2(String date, String notes,String receivedMail) {
		// 구글 이메일
		String user_email= "dohyun9160@gmail.com";
		// 구글 비번
		String user_pw = "lxrd avnm mucs wtds";
		
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

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(user_email));

	           // 받는 이메일
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(receivedMail)    
	            );
		
		  // 제목
	            message.setSubject("진척검수일정 관련 메일입니다."); 
		  
		   // 내용
	            message.setText(
	            		"안녕하세요. (주)삼김신조입니다. \n"
	            		+ date + "의 검수일정에 대해 보완사항이 있어 메일드립니다 \n"
	            		+ "보완내용 \n"
	            		+ notes +"\n" 
	            		+ "잘부탁드립니다.");

	            // 발송
	            Transport.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	    }
	
	public static void sendEmail3(String receivedMail) {
		// 구글 이메일
		String user_email= "";
		// 구글 비번
		String user_pw = "";
		
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
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user_email));
			
			// 받는 이메일
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(receivedMail)    
					);
			
			// 제목
			message.setSubject("입고 관련 메일입니다."); 
			
			// 내용
			message.setText(
					"안녕하세요. (주)삼김신조입니다. \n"
							+ "입고가 완료되어서 메일 발송드립니다. \n");
			
			// 발송
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
