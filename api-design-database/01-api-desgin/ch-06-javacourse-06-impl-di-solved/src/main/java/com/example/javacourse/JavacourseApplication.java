package com.example.javacourse;

import com.example.javacourse.mail.GoogleMailService;
import com.example.javacourse.mail.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
public class JavacourseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JavacourseApplication.class, args);
		for (String name: ctx.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

	@Bean
	public MailService mailService() {
		return new MailService("mail.com", "41");
	}

//	@Primary
	@Bean
	public MailService mailGoogle() {
		return new GoogleMailService("mail.com", "41");
	}
}
