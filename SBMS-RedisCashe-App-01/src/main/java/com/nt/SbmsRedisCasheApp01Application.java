package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SbmsRedisCasheApp01Application {

	public static void main(String[] args) {
		SpringApplication.run(SbmsRedisCasheApp01Application.class, args);
	}

}
