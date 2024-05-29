package com.Kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootForConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootForConsumerApplication.class, args);


		/*Por si alguien lo necesita, para versiones de Spring Boot 3.2.5
		La configuracion de server que funciona es:

		spring.kafka.producer.bootstrap-servers=localhost:9092

		en lugar de:
		spring.kafka.bootstrapServers=localhost:9092*/
	}

}
