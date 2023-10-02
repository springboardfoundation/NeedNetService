package org.springboardfoundation.fileservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.springbordfoundation.fileservice"})
// @Import(value = {DbLibConfig.class})
public class FileServiceConfig {
}