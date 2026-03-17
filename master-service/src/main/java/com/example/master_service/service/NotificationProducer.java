package com.example.master_service.service;

import org.springframework.stereotype.Service;

@Service
public interface NotificationProducer {
    void sendNotification(String message);
}
