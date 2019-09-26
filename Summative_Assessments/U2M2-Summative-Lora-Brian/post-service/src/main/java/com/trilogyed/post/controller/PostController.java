package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.exception.NotFoundException;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostDao postDao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post) {
        post = postDao.addPost(post);
        return post;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        Post post = postDao.getPost(id);
        if (post == null) {
            throw new NotFoundException("Sorry, we do not have any posts with that id.");
        }
        return post;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        if (post.getPostId() == 0) {
            post.setPostId(id);
        }
        if (id != post.getPostId()) {
            throw new NotFoundException("Sorry, we do not have any posts with that id.");
        }
        postDao.updatePost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);
    }
}
