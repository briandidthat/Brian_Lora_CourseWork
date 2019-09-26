package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class PostDaoTest {

    @Autowired
    PostDao postDao;

    @Before
    public void setUp() throws Exception {
        List<Post> posts = postDao.getAllPosts();
        for (Post p : posts) {
            postDao.deletePost(p.getPostId());
        }
    }

    @Test
    public void addGetDeletePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 12, 22));
        post.setPosterName("Alchemist");
        post.setPost("I am honestly enjoying Java. I never thought I would say this.");
        post = postDao.addPost(post);

        Post post1 = postDao.getPost(post.getPostId());
        assertEquals(post1, post);

        postDao.deletePost(post.getPostId());
        post1 = postDao.getPost(post.getPostId());
        assertNull(post1);
    }

    @Test
    public void getAllPosts() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 12, 22));
        post.setPosterName("Alchemist");
        post.setPost("I am honestly enjoying Java. I never thought I would say this.");
        post = postDao.addPost(post);

        List<Post> posts = postDao.getAllPosts();
        assertEquals(1, posts.size());
    }

    @Test
    public void getPostsByPoster() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 12, 22));
        post.setPosterName("Alchemist");
        post.setPost("I am honestly enjoying Java. I never thought I would say this.");
        post = postDao.addPost(post);

        List<Post> posts = postDao.getPostsByPoster("Alchemist");
        assertEquals(1, posts.size());
    }

    @Test
    public void updatePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 12, 22));
        post.setPosterName("Alchemist");
        post.setPost("I am honestly enjoying Java. I never thought I would say this.");
        post = postDao.addPost(post);

        post.setPosterName("Dr. Alchemist");
        post.setPost("Sorry, forgot I was a doctor. Refer to  me as Dr. Alchemist please.");
        postDao.updatePost(post);

        Post post1 = postDao.getPost(post.getPostId());
        assertEquals(post1, post);
    }

}