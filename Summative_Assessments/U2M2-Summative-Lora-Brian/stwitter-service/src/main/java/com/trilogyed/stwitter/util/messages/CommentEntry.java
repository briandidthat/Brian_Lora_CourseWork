package com.trilogyed.stwitter.util.messages;


import java.time.LocalDate;

public class CommentEntry {
    private int commentId;
    private int postId;
    private LocalDate createDate;
    private String commenterName;
    private String comment;

    public CommentEntry(int commentId, int postId, LocalDate createDate, String commenterName, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.createDate = createDate;
        this.commenterName = commenterName;
        this.comment = comment;
    }

    public CommentEntry() {
    }

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
    public String getComment() {
        return comment;
    }

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

}
