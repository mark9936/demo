package com.demo.repo.unittest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@Import(com.demo.config.jpa.SchoolJPAConfig.class)
@Import(com.demo.config.jpa.StoreJPAConfig.class)
@ComponentScan(basePackages = {"com.demo.repo"})
@PropertySource(value = {"classpath:infrastructure.properties"})
public class ApplicationConfig {

}
