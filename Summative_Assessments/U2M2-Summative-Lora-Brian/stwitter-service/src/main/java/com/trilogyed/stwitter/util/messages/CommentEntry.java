package com.trilogyed.stwitter.util.messages;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CommentEntry {
    private int commentId;
    private int postId;
    @JsonFormat(pattern = "mm/dd/yyyy")
    private LocalDate createDate;
    private String commenterName;
    private String comment;

    // SETTERS
    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
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
    public String toString() {
        return "CommentEntry{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", createDate=" + createDate +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
