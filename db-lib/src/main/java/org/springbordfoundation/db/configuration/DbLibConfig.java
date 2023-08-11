package org.springbordfoundation.db.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.springbordfoundation.db"})
@EntityScan(basePackages = {"org.springbordfoundation.db"})
@ComponentScan(basePackages = {"org.springbordfoundation.db"})
public class DbLibConfig {
}