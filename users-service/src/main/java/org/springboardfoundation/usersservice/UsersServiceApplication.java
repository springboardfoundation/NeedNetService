package org.springboardfoundation.usersservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.springbroadfoundation.usersservice.repositories")
@EntityScan(basePackages = "org.springbroadfoundation.usersservice.entity")
@ComponentScan(basePackages = "org.springbroadfoundation.usersservice.service")
public class UsersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApplication.class, args);
	}

}
