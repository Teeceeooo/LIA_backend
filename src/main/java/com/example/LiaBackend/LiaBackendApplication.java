package com.example.LiaBackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Repository", "Controller", "Entities","Service", "DTO"})
public class LiaBackendApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(LiaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
