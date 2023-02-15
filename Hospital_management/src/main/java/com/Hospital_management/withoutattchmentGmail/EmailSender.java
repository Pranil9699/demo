package com.Hospital_management.withoutattchmentGmail;
/*
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.hospital-m</groupId>
	<artifactId>Hospital_management</artifactId>
	<packaging>war</packaging>
	<version>0.0.1-SNAPSHOT</version>
	<name>Hospital_management Maven Webapp</name>
	<url>http://maven.apache.org</url>
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
		
<dependency>
			<groupId>jakarta.mail</groupId>
			<artifactId>jakarta.mail-api</artifactId>
			<version>2.1.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.sun.mail/javax.mail -->
		<dependency>
			<groupId>org.eclipse.angus</groupId>
			<artifactId>jakarta.mail</artifactId>
			<version>1.0.0</version>
		</dependency>

	</dependencies>
	<build>
		<finalName>Hospital_management</finalName>
	</build>
</project>
*/





import java.util.Properties;
import java.util.Random;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSender {
    public static void main(String[] args) {
    	String to = "pt130939@gmail.com";
    	final String from = "takawanepranil22@gmail.com";
        final String password = "qqfbqezriujfcnrl";
        String host = "smtp.example.com";
        String subject = "Your OTP is here!";
        String body = "Your OTP is: " + generateOTP(6);
        
        // Set mail properties
        Properties properties = new Properties();
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.port", "587");
        
        // Authenticate and create a session
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
       
        try {
            // Create a message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);
            
            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException ex) {
            System.out.println("Error sending email: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private static String generateOTP(int otpLength) {
        Random random = new Random();
        StringBuilder otp = new StringBuilder(otpLength);
        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
