package com.example.javacourse.mail;

import org.springframework.stereotype.Component;

public class MailService {

    private String url;
    private String port;


    public MailService(String url, String port) {
        this.url = url;
        this.port = port;
    }


    public void sendEmail(String to, String body) {
        System.out.println("send email");
    }
}
