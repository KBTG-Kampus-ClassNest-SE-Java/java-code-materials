package com.example.javacourse.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleMailService implements MailService {

    @Value("${mail.url}")
    private String url;

    public void sendEmail(String to, String body) {
        System.out.println("Send email via " + url);
        System.out.println("to "+ to);
    }
}
