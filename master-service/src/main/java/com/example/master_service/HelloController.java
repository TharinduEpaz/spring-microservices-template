package com.example.master_service;

import com.example.master_service.service.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final NotificationProducer notificationProducer;

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hello from Master Service");
    }

    @GetMapping("/notify")
    public Map<String, String> sendNotification() {
        notificationProducer.sendNotification("Hello from Master Service!");
        return Map.of("status", "sent", "source", "master-service");
    }
}