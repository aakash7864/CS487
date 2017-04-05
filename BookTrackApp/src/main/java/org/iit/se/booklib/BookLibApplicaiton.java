package org.iit.se.booklib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookLibApplicaiton {

	public static void main(String[] args) {
		SpringApplication.run(BookLibApplicaiton.class, args);
	}

	@Bean(name = "defaultRestTemplate")
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
}
