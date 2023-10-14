package org.springboardfoundation.usersservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.springbordfoundation.usersservice", "org.springboardfoundation.security"})
// @Import(value = {DbLibConfig.class})
public class UsersServiceConfig {
}