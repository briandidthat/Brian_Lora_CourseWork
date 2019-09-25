package com.trilogyed.post.model;

import java.time.LocalDate;
import java.util.Objects;


public class Comment {
    private int commentId;
    private int postId;
    private LocalDate createDate;
    private String commenterName;
    private String comment;

    // SETTERS
    public void setCommentId(int commentID) {
        this.commentId = commentID;
    }
    public void setPostId(int postID) {
        this.postId = postID;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // GETTERS
    public int getCommentId() {
        return commentId;
    }

    public int getPostId() {
        return postId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }


    public String getCommenterName() {
        return commenterName;
    }


    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return commentId == comment1.commentId &&
                postId == comment1.postId &&
                createDate.equals(comment1.createDate) &&
                commenterName.equals(comment1.commenterName) &&
                comment.equals(comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, createDate, commenterName, comment);
    }
}
