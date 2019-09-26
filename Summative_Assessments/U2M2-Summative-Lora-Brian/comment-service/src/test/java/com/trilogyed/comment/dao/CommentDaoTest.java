package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CommentDaoTest {

    @Autowired
    CommentDao commentDao;

    @Before
    public void setUp() throws Exception {
        List<Comment> comments = commentDao.getAllComments();
        for (Comment c : comments) {
            commentDao.deleteComment(c.getCommentId());
        }
    }

    @Test
    public void addGetDeleteComment() {
    }


    @Test
    public void getAllComments() {
    }

    @Test
    public void getCommentsByCommenter() {
    }

    @Test
    public void updateComment() {
    }

    @Test
    public void deleteComment() {
    }
}