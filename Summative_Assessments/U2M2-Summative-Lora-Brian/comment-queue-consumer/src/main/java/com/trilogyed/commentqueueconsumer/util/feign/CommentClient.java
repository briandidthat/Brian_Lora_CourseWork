package com.trilogyed.commentqueueconsumer.util.feign;

import com.trilogyed.commentqueueconsumer.model.Comment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "comment-service")
public interface CommentClient {
    @PostMapping("/comments")
    Comment createComment(@RequestBody Comment comment);

    @PutMapping("/comments/{id}")
    void updateComment(@PathVariable int id, @RequestBody Comment comment);
}
