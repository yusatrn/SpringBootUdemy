package com.spring.core.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        String message = "Hi good morning have a nice day!.";
        // SMSService smsService = new SMSService();
        //EmailService emailService = new EmailService();
        // MessageSender sender = new MessageSender(smsService);
        //    sender.sendMessage(message);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageSender sender = applicationContext.getBean(MessageSender.class);
        sender.sendMessage(message);

    }
}
