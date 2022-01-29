package com.tomjava.kurs.spirng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KursSpirngApplication {

	public static void main(String[] args) {
		SpringApplication.run(KursSpirngApplication.class, args);
	}

}
