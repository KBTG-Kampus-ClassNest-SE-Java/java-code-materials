package com.example.javacourse.mail;

public class GoogleMailService {

	private String url;
	private String port;

	public GoogleMailService() {
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setMailServer(String url) {
		this.url = url;
	}

	public void sendEmail(String to, String body) {
	}
}
