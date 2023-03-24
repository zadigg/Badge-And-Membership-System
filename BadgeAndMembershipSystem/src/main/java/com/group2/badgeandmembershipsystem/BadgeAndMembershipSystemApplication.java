package com.group2.badgeandmembershipsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableKafka
//@ComponentScan("com.group2.badge")
public class BadgeAndMembershipSystemApplication {


	public static void main(String[] args) {
		SpringApplication.run(BadgeAndMembershipSystemApplication.class, args);
	}

}
