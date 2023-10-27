package org.springboardfoundation.usersservice.configuration;

import org.springboardfoundation.client.WebServiceFactory;
import org.springboardfoundation.client.user.UserWebService;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static org.springboardfoundation.common.web.ApiConstants.USER_DB_SERVER_PATH;

@Configuration
@ComponentScan(basePackages = {"org.springbordfoundation.usersservice", "org.springboardfoundation.security"})
// @Import(value = {DbLibConfig.class})
public class UsersServiceConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public UserWebService userWebService() {
        return WebServiceFactory.createUserWebService(restTemplate(), USER_DB_SERVER_PATH);
    }
}