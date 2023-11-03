package com.example.javacourse.order;

import com.example.javacourse.mail.GoogleMailService;

public class OrderService {

	private GoogleMailService googleMailService;

	public OrderService() {
		this.googleMailService = new GoogleMailService("mail.google.com", "41");
	}

	public void createOrder() {
//        create order
//        send mail
		googleMailService.sendEmail("", "");
	}
}
