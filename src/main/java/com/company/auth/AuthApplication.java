package com.company.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.company.auth"})
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

//	@Bean
//	@Primary
//	public AuthenticationManager customAuthenticationManagerBean(AuthenticationManagerBuilder builder) throws Exception {
//		return builder.build();
//	}
}
