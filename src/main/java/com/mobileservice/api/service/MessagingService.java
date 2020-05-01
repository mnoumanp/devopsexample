package com.mobileservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessagingService{

	@Autowired
    private JavaMailSender sender;
	
	@Value("${email.from}")
	private String fromEmail;
	
	
	public Boolean sendOtpEmail(String toEmail, String otp) throws Exception {
		Boolean result = false;
		SimpleMailMessage message=null;
		try {
			message = new SimpleMailMessage();
			message.setFrom(fromEmail);
        	message.setTo(toEmail);
        	message.setSubject("OTP forgot password : Doctor Mobile");
        	message.setText("Your OTP for resetting new password is "+otp);
        	sender.send(message);
        	result = true;
		}catch(Exception e) {
			throw new Exception("error sending email");
		}
		return result;
	}
	

	
}
