package com.example.databaseConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigServer
@ComponentScan("com.example")
public class DatabaseConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseConfigServerApplication.class, args);
	}

}
