package com.abhijeet.nexum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NexumApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexumApplication.class, args);
	}

}
