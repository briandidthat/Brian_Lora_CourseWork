package com.trilogyed.post.viewmodel;

import com.trilogyed.post.model.Comment;

import java.time.LocalDate;
import java.util.List;


public class PostViewModel {
    private int postId;
    private LocalDate createDate;
    private String posterName;
    private String post;
    private List<Comment> comments;

    // SETTERS
    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // GETTERS
    public int getPostId() {
        return postId;
    }
    public LocalDate getCreateDate() {
        return createDate;
    }
    public String getPosterName() {
        return posterName;
    }
    public String getPost() {
        return post;
    }
    public List<Comment> getComments() {
        return comments;
    }

}
