package com.kafkalearn.service;

import com.kafkalearn.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send(AppConstant.TOPIC_NAME, message);
        completableFuture.whenComplete((result, ex) -> {

            if (ex == null) {
                System.out.println("Sent message = [" + message + "] with offset = [" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message = [" + message + "] due to exception : " + ex.getMessage());
            }

        });
    }

}
