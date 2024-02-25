package com.kafkalearn.service;

import com.kafkalearn.AppConstant;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @KafkaListener(topics = AppConstant.TOPIC_NAME, groupId = "app-group")
    public void consume1(String message) {
       // System.out.println("currentThread : "+Thread.currentThread().getName());
        System.out.println("consumer1 message received : " + message);
    }

    //each consumer method acts as a separate consumer instance
    @KafkaListener(topics = AppConstant.TOPIC_NAME, groupId = "app-group")
    public void consume2(String message) {
        // System.out.println("currentThread : "+Thread.currentThread().getName());
        System.out.println("consumer2 message received : " + message);
    }

    @KafkaListener(topics = AppConstant.TOPIC_NAME, groupId = "app-group")
    public void consume3(String message) {
        // System.out.println("currentThread : "+Thread.currentThread().getName());
        System.out.println("consumer3 message received : " + message);
    }

}
