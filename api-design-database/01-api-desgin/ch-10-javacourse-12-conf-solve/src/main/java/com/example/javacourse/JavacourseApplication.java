package com.example.javacourse;

import com.example.javacourse.mail.MailService;
import com.example.javacourse.mail.MockMailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class JavacourseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JavacourseApplication.class, args);

	}

	@Profile("local")
	@Bean
	public MailService mailService() {
		return new MockMailService("","");
	}
}
