package com.zeta.springKafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

}
