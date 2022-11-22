package org.springboardfoundation.usersservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan
@EnableJpaRepositories
//@EnableAutoConfiguration
//@ComponentScans(value = {@ComponentScan("org.springboardfoundation.usersservice"),@ComponentScan("org.springboardfoundation.db")})
@ComponentScan({
		"org.springboardfoundation.usersservice.*","org.springboardfoundation.db.*"
})
@SpringBootApplication
public class UsersServiceApplication {

	public static void main(String[] args) {
		// SpringApplication.run(UsersServiceApplication.class, "--debug")
		SpringApplication.run(UsersServiceApplication.class, args);
	}
}
