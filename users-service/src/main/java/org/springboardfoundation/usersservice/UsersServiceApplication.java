package org.springboardfoundation.usersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan
@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication
public class UsersServiceApplication {

	public static void main(String[] args) {
		 //SpringApplication.run(UsersServiceApplication.class, "--debug");
		SpringApplication.run(UsersServiceApplication.class, args);
	}
}