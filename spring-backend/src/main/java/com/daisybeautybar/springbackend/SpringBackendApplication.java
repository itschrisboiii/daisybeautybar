package com.daisybeautybar.springbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBackendApplication {

	public static void main(String[] args) {

		ApplicationContext apc = SpringApplication.run(SpringBackendApplication.class, args);
//		for (String s : apc.getBeanDefinitionNames()) {
//			System.out.println(s);
//		}
	}

}
