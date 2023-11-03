package com.example.javacourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class JavacourseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JavacourseApplication.class, args);
//		for (String bean: ctx.getBeanDefinitionNames()) {
//			System.out.println(bean);
//		}
	}

	@Bean
	@Profile("dev")
	public String onlyDevBean() {
		return "I'm dev env";
	}
}
