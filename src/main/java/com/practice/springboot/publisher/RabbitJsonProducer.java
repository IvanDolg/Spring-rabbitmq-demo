package com.practice.springboot.publisher;

import com.practice.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitJsonProducer {
    @Value("${spring.rabbitmq.exchange.name}")
    private String exchange;

    @Value("${spring.rabbitmq.json.routing.key}")
    private String routingJsonKey;

    private static final Logger logger = LoggerFactory.getLogger(RabbitJsonProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User user) {
        logger.info(String.format("Message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
}
