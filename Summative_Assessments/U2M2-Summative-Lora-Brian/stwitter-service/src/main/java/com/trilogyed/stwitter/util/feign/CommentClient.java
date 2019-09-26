package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "comment-client")
public interface CommentClient {
    @GetMapping("/notes")
    List<Comment> getAllComments();

    @GetMapping("/notes/{postId}")
    List<Comment> getCommentsByPostId(@PathVariable int postId);
}
