package com.tech45degree.driverservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class DriverService {


    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Scheduled(cron = "0/5 * * * * *")
    private void sendMessage(){
        String coordinates = "x: "+getCoordinates()+" y: "+getCoordinates();
        System.out.println("sendMessage at : "+ LocalDateTime.now());
        kafkaTemplate.send("TopicA",coordinates);
    }

    private String getCoordinates(){
        Random random = new Random();
        return String.valueOf(new BigDecimal(random.nextDouble()/100).setScale(2,BigDecimal.ROUND_UP));
    }
}
