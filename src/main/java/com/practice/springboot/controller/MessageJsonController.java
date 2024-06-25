package com.practice.springboot.controller;

import com.practice.springboot.dto.User;
import com.practice.springboot.publisher.RabbitJsonProducer;
import com.practice.springboot.publisher.RabbitProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    private RabbitJsonProducer rabbitJsonProducer;

    public MessageJsonController(RabbitJsonProducer rabbitJsonProducer) {
        this.rabbitJsonProducer = rabbitJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent successfully");
    }
}
