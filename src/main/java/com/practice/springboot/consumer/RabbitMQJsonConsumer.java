package com.practice.springboot.consumer;

import com.practice.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = "${spring.rabbitmq.json.queue.name  }")
    public void consume(User user) {
        logger.info(String.format("Message received -> %s", user.toString()));
    }
}
