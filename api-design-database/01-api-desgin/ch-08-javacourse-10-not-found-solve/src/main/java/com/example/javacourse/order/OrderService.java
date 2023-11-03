package com.example.javacourse.order;

import com.example.javacourse.mail.MailService;

public class OrderService {

    private MailService mailService;

    public OrderService() {
//        this.mailService = new MailService();
        this.mailService = new MailService("mail.google.com", "41");

    }

    public void createOrder() {
//        create order
//        send mail
        mailService.sendEmail("", "");
    }
}
