package com.trilogyed.stwitter.viewmodel;

import com.trilogyed.stwitter.model.Comment;

import java.time.LocalDate;
import java.util.List;

/*Task:
 *
 */
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
}
