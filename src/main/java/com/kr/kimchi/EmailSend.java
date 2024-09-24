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
	
	//��ȸ��
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
		// ���� �̸���
		String user_email= "dohyun9160@gmail.com";
		// ���� ���
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

	           // �޴� �̸���
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(receivedMail)    
	            );
		
		  // ����
	            message.setSubject("��ô�˼����� ���� �����Դϴ�."); 
		  
		   // ����
	            message.setText(
	            		"�ȳ��ϼ���. (��)�������Դϴ�. \n"
	            		+ date + "�� �˼������� �������ϴ�. \n"
	            		+ " \n"
	            		+ parthner +"�� �˼� �����̴� Ȯ�κ�Ź�帳�ϴ�.\n");

	            // �߼�
	            Transport.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	    }
	
	public static void sendEmail2(String date, String notes,String receivedMail) {
		// ���� �̸���
		String user_email= "dohyun9160@gmail.com";
		// ���� ���
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

	           // �޴� �̸���
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(receivedMail)    
	            );
		
		  // ����
	            message.setSubject("��ô�˼����� ���� �����Դϴ�."); 
		  
		   // ����
	            message.setText(
	            		"�ȳ��ϼ���. (��)�������Դϴ�. \n"
	            		+ date + "�� �˼������� ���� ���ϻ����� �־� ���ϵ帳�ϴ� \n"
	            		+ "���ϳ��� \n"
	            		+ notes +"\n" 
	            		+ "�ߺ�Ź�帳�ϴ�.");

	            // �߼�
	            Transport.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	    }
	
	public static void sendEmail3(String receivedMail) {
		// ���� �̸���
		String user_email= "";
		// ���� ���
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
			
			// �޴� �̸���
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(receivedMail)    
					);
			
			// ����
			message.setSubject("�԰� ���� �����Դϴ�."); 
			
			// ����
			message.setText(
					"�ȳ��ϼ���. (��)�������Դϴ�. \n"
							+ "�԰� �Ϸ�Ǿ ���� �߼۵帳�ϴ�. \n");
			
			// �߼�
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
