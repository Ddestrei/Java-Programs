package org.ddestrei.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "ddestrei", groupId = "groupId")
    void listener(String data){
        System.out.println("Received: "+ data);
    }

}
