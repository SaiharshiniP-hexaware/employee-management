package com.hexa;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootEmpAppApplication extends SpringBootServletInitializer {
	@Autowired
	private EntityManagerFactory emf;

	@Bean
	public SessionFactory getSessionFactory() {
		return emf.unwrap(SessionFactory.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmpAppApplication.class, args);
	}
}
