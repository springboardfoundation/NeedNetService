package org.springboardfoundation.needsservice.configuration;

import org.springbordfoundation.db.configuration.DbLibConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"org.springbordfoundation.needsservice"})
@Import(value = {DbLibConfig.class})
public class NeedsServiceConfig {
}