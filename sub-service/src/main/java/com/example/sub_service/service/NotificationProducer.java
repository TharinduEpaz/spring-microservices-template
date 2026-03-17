package com.example.sub_service.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducer {

    private static final Logger log = LoggerFactory.getLogger(NotificationProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "notification-topic";

    public void sendNotificationEvent(String message) {
        log.info("Sending notification to topic '{}': {}", TOPIC, message);
        kafkaTemplate.send(TOPIC, message)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to send notification to topic '{}': {}", TOPIC, ex.getMessage(), ex);
                    } else {
                        log.debug("Notification delivered to topic '{}' partition={} offset={}",
                                TOPIC,
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    }
                });
    }
}