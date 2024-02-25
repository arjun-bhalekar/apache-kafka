package com.kafkalearn.controller;

import com.kafkalearn.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event/")
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}/{count}")
    public ResponseEntity<?> publishMessage(@PathVariable String message, @PathVariable int count) {
        try {

            for (int i = 0; i < count; i++) {
                kafkaMessagePublisher.sendMessageToTopic(message + "-" + i);
            }
            return ResponseEntity.ok("message published successfully");
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
