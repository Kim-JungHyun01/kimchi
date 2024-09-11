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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailSend {
	
	//��ȸ��
	@PostMapping(value="/mail")
	public ModelAndView mail(@RequestParam("date") String date, @RequestParam("parthner") String parthner,@RequestParam("receivedMail") String receivedMail) {
		ModelAndView mav = new ModelAndView();
		sendEmail(date, parthner,receivedMail);
		mav.setViewName("pa/paDetail");
		return mav;
	}

	@PostMapping(value="/mail2")
	public ModelAndView mail2(@RequestParam("date") String date, @RequestParam("notes") String notes,@RequestParam("receivedMail") String receivedMail) {
		ModelAndView mav = new ModelAndView();
		sendEmail2(date, notes,receivedMail);
		mav.setViewName("pa/paDetail");
		return mav;
	}
	
	public static void sendEmail(String date, String parthner, String receivedMail) {
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
}
