package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "comment-client")
public interface CommentClient {
    @PostMapping("/comments")
    Comment createComment(@RequestBody Comment comment);

    @GetMapping("/comments")
    List<Comment> getAllComments();

    @GetMapping("/comments/{id}")
    Comment findCommentById(@PathVariable int id);

    @PutMapping("/comments/{id}")
    void updateComment(@PathVariable int id, @RequestBody Comment comment);

    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable int id);

    @GetMapping("/commenter/{commenterName}")
    List<Comment> findCommentsByCommenter(@PathVariable String commenterName);

    @GetMapping("/notes/{postId}")
    List<Comment> getCommentsByPostId(@PathVariable int postId);
}
