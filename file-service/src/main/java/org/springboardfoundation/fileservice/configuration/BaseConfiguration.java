package org.springboardfoundation.fileservice.configuration;

import java.util.concurrent.Executor;

import org.springboardfoundation.common.utiliy.JacksonUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableConfigurationProperties
public class BaseConfiguration {

    @Primary
    @Bean
    public ObjectMapper objectMapper() {
        return JacksonUtils.createObjectMapper();
    }

    @Bean
    @Validated
    @ConfigurationProperties("app.file")
    public AssetProperties assetConfiguration() {
        return new AssetProperties();
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("FSAsync-");
        executor.initialize();
        return executor;
    }
}