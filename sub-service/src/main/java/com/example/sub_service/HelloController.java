package com.example.sub_service;

import com.example.sub_service.service.NotificationProducer;
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
        return Map.of("message", "Hello from Sub Service");
    }

    @GetMapping("/notify")
    public Map<String, String> sendNotification() {
        notificationProducer.sendNotificationEvent("Hello from Sub Service!");
        return Map.of("status", "sent", "source", "sub-service");
    }
}