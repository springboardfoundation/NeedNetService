package org.springboardfoundation.usersservice.configuration;

import org.springbordfoundation.db.configuration.DbLibConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"org.springbordfoundation.usersservice"})
@Import(value = {DbLibConfig.class})
public class UsersServiceConfig {
}