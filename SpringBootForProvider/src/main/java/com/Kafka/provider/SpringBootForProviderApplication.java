package com.Kafka.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication

public class SpringBootForProviderApplication {
	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootForProviderApplication.class, args);
	}

	@Bean
	CommandLineRunner init(){
		return args -> {
			kafkaTemplate.send("topicExample-Topic","Final test from KAFKA part 3");
		};
	}

}
