package com.example.javacourse.mail;

public class MockMailService extends MailService {

    public MockMailService(String url, String port) {
        super(url, port);
    }

    @Override
    public void sendEmail(String to, String body) {
        System.out.println("fake send email");
    }
}
