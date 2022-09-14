package com.example.spirits.spirits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpiritsApplication {

	public static void main(String[] args) {
		System.out.println("current build");
		SpringApplication.run(SpiritsApplication.class, args);
		System.out.println("current build");

	}

}
