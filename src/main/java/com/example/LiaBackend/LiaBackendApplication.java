package com.example.LiaBackend;

import javax.sql.DataSource;

import Controller.CountryController;
import Entities.Country;
import Repository.CountryRepository;
import Repository.CountryRepositoryImpl;
import Repository.ItemRepository;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
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
