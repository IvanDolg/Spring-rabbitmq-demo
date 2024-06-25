package com.practice.springboot.controller;

import com.practice.springboot.publisher.RabbitProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitProducer rabbitProducer;

    public MessageController(RabbitProducer rabbitProducer) {
        this.rabbitProducer = rabbitProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitProducer.send(message);
        return ResponseEntity.ok("Message sent successfully");
    }
}
