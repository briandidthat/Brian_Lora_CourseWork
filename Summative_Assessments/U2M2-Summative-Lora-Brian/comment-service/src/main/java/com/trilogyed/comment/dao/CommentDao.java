package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {
    Comment addComment(Comment comment);

    List<Comment> getCommentsByPostId(int postId);
    List<Comment> getAllComments();
    List<Comment> getCommentsByCommenter(String commenterName);

    void updateComment(Comment comment);
    void deleteComment(int id);
}
