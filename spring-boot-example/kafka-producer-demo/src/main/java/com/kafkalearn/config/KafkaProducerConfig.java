package com.kafkalearn.config;

import com.kafkalearn.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(AppConstant.TOPIC_NAME, AppConstant.NO_OF_PARTITIONS, AppConstant.REPLICATION_FACTOR);
    }
}
