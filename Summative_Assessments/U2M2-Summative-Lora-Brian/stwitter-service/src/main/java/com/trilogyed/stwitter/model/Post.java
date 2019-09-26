package com.trilogyed.stwitter.model;

import java.time.LocalDate;
import java.util.Objects;


public class Post {
    private int postId;
    private LocalDate postDate;
    private String posterName;
    private String post;

    // SETTERS
    public void setPostId(int postID) {
        this.postId = postId;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public void setPost(String post) {
        this.post = post;
    }

    // GETTERS
    public int getPostId() {
        return postId;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public String getPost() {
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post1 = (Post) o;
        return postId == post1.postId &&
                postDate.equals(post1.postDate) &&
                posterName.equals(post1.posterName) &&
                post.equals(post1.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postDate, posterName, post);
    }
}
