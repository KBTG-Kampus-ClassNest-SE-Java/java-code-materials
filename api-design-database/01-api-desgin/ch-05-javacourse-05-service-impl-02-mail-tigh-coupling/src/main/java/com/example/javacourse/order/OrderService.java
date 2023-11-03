package com.example.javacourse.order;

import com.example.javacourse.mail.GoogleMailService;

public class OrderService {

	private GoogleMailService googleMailService;

	public OrderService() {
		this.googleMailService = new GoogleMailService();
		this.googleMailService.setMailServer("mail.google.com");
		this.googleMailService.setPort("41");
	}

	public void createOrder() {
//        create order
//        send mail
		googleMailService.sendEmail("", "");
	}
}
