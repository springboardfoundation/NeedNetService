package org.springboardfoundation.fileservice.configuration;

import org.springbordfoundation.db.configuration.DbLibConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"org.springbordfoundation.fileservice"})
@Import(value = {DbLibConfig.class})
public class FileServiceConfig {
}