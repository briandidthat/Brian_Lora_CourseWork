package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.service.ServiceLayer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StwitterController {
    private ServiceLayer service;
    private RabbitTemplate rabbitTemplate;

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.comment.controller";

    @Autowired
    public StwitterController(ServiceLayer service, RabbitTemplate rabbitTemplate) {
        this.service = service;
        this.rabbitTemplate = rabbitTemplate;
    }

}
