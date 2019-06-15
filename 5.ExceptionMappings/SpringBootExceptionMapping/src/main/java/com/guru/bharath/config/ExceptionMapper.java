package com.guru.bharath.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ExceptionMapper {

	
	@Bean
	public HandlerExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver er = new SimpleMappingExceptionResolver();
		er.setExceptionMappings(properties());
		er.setDefaultErrorView("genericErrorView");
		return er;
	}
	
	
	public Properties properties() {
		Properties prop = new Properties();
		prop.setProperty("java.lang.RuntimeException", "runtimeErrorView");
		return prop;
	}
}

