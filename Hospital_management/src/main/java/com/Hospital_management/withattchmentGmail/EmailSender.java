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

















package com.Hospital_management.withattchmentGmail;

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

import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.activation.*;

import java.util.Properties;
import java.io.File;
import java.io.IOException;

public class EmailSender {
    public static void main(String[] args) {

        // Recipient's email address and message
        
        String subject = "Test email with attachment";
        String body = "This is a test email with attachment.";

        String to = "demog650@gmail.com";
    	final String from = "takawanepranil22@gmail.com";
        final String password = "qqfbqezriujfcnrl";
        // SMTP server properties
        String host = "smtp.gmail.com";
        String port = "587";

        // Setup SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with SMTP server and authenticate
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Create a message object
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Create a body part for the message text
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            multipart.addBodyPart(messageBodyPart);

            // Fetch the file from the local file system
            String filename = "BCA-244 C-- Programming Laboratory.pdf";
            File file = new File("C:\\Users\\BCA14\\Downloads\\BCA-244 C-- Programming Laboratory.pdf");

            // Create a body part for the attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Add the multipart message to the message object
            message.setContent(multipart);

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
