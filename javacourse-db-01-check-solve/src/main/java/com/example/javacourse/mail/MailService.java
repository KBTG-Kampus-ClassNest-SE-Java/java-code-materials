package com.example.javacourse.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @Value("${mail.url}")
    private String url;
    @Value("${mail.port}")
    private String port;
    @Value("${mail.key}")
    private String key;

    public void sendMail(String to, String content) {
        System.out.println("Server " + url + " " + port);
        System.out.println("To " + to );
        System.out.println("Content " + content );

    }

}
