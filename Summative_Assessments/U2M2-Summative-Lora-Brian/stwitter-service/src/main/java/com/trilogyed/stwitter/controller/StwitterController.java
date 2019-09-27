package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.messages.CommentEntry;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @PostMapping("/posts/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNote(@RequestBody CommentEntry commentEntry) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, commentEntry);
    }
}
