package com.hepsiemlak.packageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PackageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackageServiceApplication.class, args);
	}

}
