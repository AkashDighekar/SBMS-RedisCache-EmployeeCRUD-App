package com.nt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
		
	    @Bean
		public OpenAPI redisApiDoc(@Value("${springdoc.version}") String version) {
			return new OpenAPI().components(new Components()).info(new Info()
					.title("Redis-Cache-App").version(version)
					.license(new License().name("Apache 2.0").url("http://springdoc.org")));
		}
}
