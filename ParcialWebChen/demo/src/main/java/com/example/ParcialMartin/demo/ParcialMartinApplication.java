package com.example.ParcialMartin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.ParcialMartin.demo.model") // Adjust the package path accordingly
@ComponentScan(basePackages = "com.example.ParcialMartin.demo")
@EnableJpaRepositories("com.example.ParcialMartin.demo.repository")
public class ParcialMartinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcialMartinApplication.class, args);
	}

}
