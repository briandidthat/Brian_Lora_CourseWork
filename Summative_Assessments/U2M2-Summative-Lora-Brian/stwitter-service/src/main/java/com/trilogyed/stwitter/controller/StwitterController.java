package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.messages.CommentEntry;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
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

    // POSTS ROUTES
    //=============================================================================================
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getAllPosts() {
        return service.findAllPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel createPost(@RequestBody @Valid Post post) {
        return service.savePost(post);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable int id, @RequestBody @Valid Post post) {
        if (post.getPostId() == 0) {
            post.setPostId(id);
        }
        if (id != post.getPostId()) {
            throw new IllegalArgumentException("Post Id and the id on path must match!");
        }
        service.updatePost(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        service.removePost(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int id) {
        return service.findPost(id);
    }

    @GetMapping("/user/{posterName}")
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getPostsByPoster(@PathVariable String posterName) {
        return service.findPostsByPoster(posterName);
    }

    // COMMENTS ROUTES
    //==============================================================================================
    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody @Valid CommentEntry commentEntry) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, commentEntry);
    }

    @PutMapping("/posts/comments/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateComment(@PathVariable int id, @RequestBody @Valid CommentEntry commentEntry) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, commentEntry);
    }



}
