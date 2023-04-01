package org.ddestrei.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class MainKafka {
    public static void main(String[] args) {
        SpringApplication.run(MainKafka.class,args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
        return (args) -> {
          kafkaTemplate.send("ddestrei", "Hello Kafka123");
        };
    }

}
