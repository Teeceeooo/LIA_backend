package com.example.LiaBackend;

import javax.sql.DataSource;

import Controller.CountryController;
import Entities.Country;
import Repository.CountryRepository;
import Repository.CountryRepositoryImpl;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Repository", "Controller", "Entities","Player"})
public class LiaBackendApplication implements CommandLineRunner {

	// Create CountryService. Replace this with CountryService, and place this in CountyService instead.
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Country country = countryRepository.findById(3L);
		System.out.println(country.getName()); // Skriver ut namnet på landet med id 3

		countryRepository.findAll().forEach(country2 -> System.out.println(country2.getName()));
	}
}
