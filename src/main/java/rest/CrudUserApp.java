package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"rest.services", "rest.controllers"})
public class CrudUserApp {

	public static void main(String[] args) {
		SpringApplication.run(CrudUserApp.class, args);
	}
}
