package org.springboardfoundation.needsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class NeedsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeedsServiceApplication.class, args);
	}

}