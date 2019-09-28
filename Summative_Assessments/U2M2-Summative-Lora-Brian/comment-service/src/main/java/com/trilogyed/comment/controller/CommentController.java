package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RefreshScope
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentDao commentDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody @Valid Comment comment) {
        return commentDao.addComment(comment);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findAllComments() {
        return commentDao.getAllComments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment findCommentById(@PathVariable int id) {
        return commentDao.getComment(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable int id, @RequestBody Comment comment) {
        commentDao.updateComment(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {
        commentDao.deleteComment(id);
    }

    @GetMapping("/post/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findCommentsByPostId(@PathVariable int postId) {
        return commentDao.getCommentsByPostId(postId);
    }

    @GetMapping("/commenter/{commenterName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findCommentsByCommenter(@PathVariable String commenterName) {
        return commentDao.getCommentsByCommenter(commenterName);
    }

}
