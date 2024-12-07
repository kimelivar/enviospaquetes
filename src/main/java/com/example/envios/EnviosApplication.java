package com.example.envios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnviosApplication {

	public static void main(String[] args) {
		new Thread(() -> SpringApplication.run(EnviosApplication.class, args)).start();
	}
}

