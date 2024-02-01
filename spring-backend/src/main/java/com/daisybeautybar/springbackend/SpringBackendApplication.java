package com.daisybeautybar.springbackend;

import com.daisybeautybar.springbackend.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class SpringBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBackendApplication.class, args);
//		for (String s : apc.getBeanDefinitionNames()) {
//			System.out.println(s);
//		}
	}

}
