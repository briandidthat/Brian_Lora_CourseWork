package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.messages.CommentEntry;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CacheConfig(cacheNames = {"posts"})
@RequestMapping(value = "/posts")
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

    @CachePut(key = "#result.getPostId()")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel createPost(@RequestBody @Valid Post post) {
        return service.savePost(post);
    }

    @CacheEvict(key = "#post.getPostId()")
    @PutMapping(value = "/{id}")
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

    @CacheEvict
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        service.removePost(id);
    }

    @Cacheable
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int id) {
        return service.findPost(id);
    }

    @GetMapping(value = "/user/{posterName}")
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getPostsByPoster(@PathVariable String posterName) {
        return service.findPostsByPoster(posterName);
    }

    // COMMENTS ROUTES
    //==============================================================================================
    @GetMapping(value = "/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments() {
        return service.findAllComments();
    }

    @PostMapping(value = "/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody @Valid CommentEntry commentEntry) {
        System.out.println("Sending message....");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, commentEntry);
        System.out.println("Message sent. " + commentEntry.toString());
    }

    @GetMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getComment(@PathVariable int id) {
        Comment comment = service.findCommentById(id);
        if (comment == null) {
            throw new NotFoundException("Sorry, we do not have a comment with that id.");
        }
        return comment;
    }

    @PutMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable int id, @RequestBody @Valid CommentEntry commentEntry) {
        if (commentEntry.getCommentId() == 0) {
            commentEntry.setCommentId(id);
        }
        if (id != commentEntry.getCommentId()) {
            throw new IllegalArgumentException("Comment Id in object & path much match!");
        }

        System.out.println("Sending message....");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, commentEntry);
        System.out.println();
    }

    @DeleteMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {
        service.removeComment(id);
    }

    @GetMapping(value = "/comments/post/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getCommentsByPostId(@PathVariable int postId) {
        List<Comment> comments = service.findCommentsByPostId(postId);
        if (comments == null) {
            throw new NotFoundException("Sorry, we do not have a comment with that post id.");
        }
        return comments;
    }

    @GetMapping(value = "/comments/user/{commenterName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getCommentsByCommenter(@PathVariable String commenterName) {
        List<Comment> comments = service.findAllCommentsByCommenter(commenterName);
        if (comments == null) {
            throw new NotFoundException("Sorry, we do not have a comment with that post id.");
        }
        return comments;
    }

}
