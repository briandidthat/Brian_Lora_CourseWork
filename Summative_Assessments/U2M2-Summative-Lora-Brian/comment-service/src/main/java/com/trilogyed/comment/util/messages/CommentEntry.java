package com.trilogyed.comment.util.messages;


public class CommentEntry {
    private int commentId;
    private int postId;
    private int createDate;
    private String commenterName;
    private String comment;

    public CommentEntry(int postId, int createDate, String commenterName, String comment) {
        this.postId = postId;
        this.createDate = createDate;
        this.commenterName = commenterName;
        this.comment = comment;
    }

    public CommentEntry() {
    }


    // SETTERS
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setCreateDate(int createDate) {
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

    public int getCreateDate() {
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
