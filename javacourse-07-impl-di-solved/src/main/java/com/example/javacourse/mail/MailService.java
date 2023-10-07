package com.example.javacourse.mail;

import org.springframework.stereotype.Component;

public class MailService {

    private String url;
    private String port;

//    private String key;

    public MailService(String url, String port) {
        this.url = url;
        this.port = port;
    }

//    public MailService(String url, String port, String key) {
//        this.url = url;
//        this.port = port;
//        this.key = key;
//    }

    public void sendEmail(String to, String body) {}
}
