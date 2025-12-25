package com.example.springbootPostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPostgresqlApplication.class, args);

		System.out.println("server running on PORT 5000");
	}

}
