package com.trilogyed.stwitter.viewmodel;

import com.trilogyed.stwitter.model.Comment;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class PostViewModel {
    private int postId;
    private LocalDate postDate;
    private String posterName;
    private String post;
    private List<Comment> comments;

    // SETTERS
    public void setPostId(int postId) {
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

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return postId == that.postId &&
                postDate.equals(that.postDate) &&
                posterName.equals(that.posterName) &&
                post.equals(that.post) &&
                comments.equals(that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postDate, posterName, post, comments);
    }
}
