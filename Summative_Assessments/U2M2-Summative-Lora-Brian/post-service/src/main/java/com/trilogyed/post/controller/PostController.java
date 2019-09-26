package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.exception.NotFoundException;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    PostDao postDao;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getPosts() {
        return postDao.getAllPosts();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return postDao.addPost(post);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Post getPost(@PathVariable int id) {
        Post post = postDao.getPost(id);
        if (post == null) {
            throw new NotFoundException("Sorry, we do not have any posts wit the id: " + id);
        }
        return post;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        if (post.getPostId() == 0) {
            post.setPostId(id);
        }
        if (id != post.getPostId()) {
            throw new IllegalArgumentException("The path id and post id do not match: " + id);
        }
        postDao.updatePost(post);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);
    }

    @GetMapping("/user/{posterName}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getPostsByPoster(@PathVariable String posterName) {
        List<Post> posts = postDao.getPostsByPoster(posterName);
        if (posts == null) {
            throw new NotFoundException("Sorry, we do not have any posts by the user: " + posterName);
        }
        return posts;
    }
}
