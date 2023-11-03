package com.example.javacourse.mail;

public class GoogleMailService {

	private String url;
	private String port;

//    private String key;

	public GoogleMailService() {
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setMailServer(String url) {
		this.url = url;
	}

	//    public MailService(String url, String port, String key) {
//        this.url = url;
//        this.port = port;
//        this.key = key;
//    }

	public void sendEmail(String to, String body) {
	}
}
