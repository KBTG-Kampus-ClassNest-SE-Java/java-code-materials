package com.example.javacourse.mail;

public class GoogleMailService extends MailService {


    public GoogleMailService(String url, String port) {
        super(url, port);
    }

    public void sendEmail(String to, String body) {
        System.out.println("send google email");
    }
}
