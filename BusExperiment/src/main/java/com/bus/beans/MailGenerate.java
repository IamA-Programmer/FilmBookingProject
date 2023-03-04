package com.bus.beans;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailGenerate {

	public MailGenerate() {
		System.out.println("Mail Class Invoked");
	}
	
	public void sendEmail(String moviename,List<String> seats,String name,Date bookeddate,String time,double sum,String customername,String email) {
		
		String to=email;
		String sender="sender@gmail.com";
		String host="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
	
		String status="paid";
		
		 Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication("kishorecoder685@gmail.com","gcajsiqaufwansfa");
	          }
	          });
	          
	          try
	          {
	                MimeMessage message = new MimeMessage(session);
	             message.setFrom(new InternetAddress(sender));
	             message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setSubject("Kishore Cinemas"); 
	          
				
				  message.setContent("<table border=1 solid black><tr>" +
				  "<th>CustomerName</th>" + "<th>Moviename</th>" + "<th>ShowDate</th>" +
				  "<th>ShowTime</th>" + "<th>Total</th>" + "<th>Seats Booked</th>" +
				  "<th>Booking Status</th>" + "</tr>" +"<tr><td>"+customername+"</td>" +
				  "<td>"+moviename+"</td>" + "<td>"+bookeddate+"</td>" + "<td>"+time+"</td>" +
				  "<td>"+sum+"</td>" + "<td>"+seats+"</td>" + "<td>"+status+"</td>" +
				  "</tr></table>" ,"text/html");
				 
	             Transport.send(message);
	             System.out.println("Mail successfully sent");
	          }
	          catch (MessagingException mex)
	          {
	             mex.printStackTrace();
	          }
	  }
}
