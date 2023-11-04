package com.tech45degree.clientservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @KafkaListener(topics = "TopicA", groupId = "group1")
    private void listen(String message){
        System.out.println(message);
    }
}
