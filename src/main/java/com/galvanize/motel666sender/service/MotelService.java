package com.galvanize.motel666sender.service;

import com.galvanize.motel666sender.entity.UserEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MotelService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${amqp.exchange.name}")
    String exchangeName;
    @Value("${amqp.logging.routing.key}")
    String loggingRoutingKey;

    @Autowired
    public MotelService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public UserEvent bookingRoom(String userId) {
        UserEvent userEvent = UserEvent.builder()
                .type("booking room")
                .userId(userId)
                .context("some context")
                .build();
        rabbitTemplate.convertAndSend(exchangeName, loggingRoutingKey, userEvent);
        return userEvent;
    }
}
