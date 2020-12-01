package com.alacriti.supplierportal.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CrossFilter implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
			.allowedMethods("POST");
}
	
}
