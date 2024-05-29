package com.Kafka.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService implements CommandLineRunner {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;


    @Override
    public void run(String... args) throws Exception {
        kafkaTemplate.send("topicExample-Topic","Testing kafka");
    }
}
