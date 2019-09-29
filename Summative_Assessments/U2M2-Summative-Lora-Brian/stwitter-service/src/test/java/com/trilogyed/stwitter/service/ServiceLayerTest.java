package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ServiceLayerTest {

    PostClient postClient;
    CommentClient commentClient;
    ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {
        setUpCommentMock();
        setUpPostMock();
        serviceLayer = new ServiceLayer(postClient,commentClient);
    }

    @Test
    public void AddGetDeletePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 11, 11));
        post.setPosterName("The Alchemist");
        post.setPost("Let's put Tomi Lahren in a rocket and send her off into space to never return.");
        PostViewModel postViewModel = serviceLayer.savePost(post);

        PostViewModel fromService = serviceLayer.findPost(postViewModel.getPostId());
        assertEquals(fromService, postViewModel);
    }

    private void setUpCommentMock() {
        commentClient = mock(CommentClient.class);

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2019,11,12));
        comment.setCommenterName("Morpheus");
        comment.setComment("Can we add Laura Ingram?!");

        Comment comment2 = new Comment();
        comment2.setPostId(2);
        comment2.setCreateDate(LocalDate.of(2019,11,12));
        comment2.setCommenterName("Morpheus");
        comment2.setComment("This is a great take!");

        List<Comment> commentsByMorpheus = new ArrayList<>();
        commentsByMorpheus.add(comment);

        Comment comment1 = new Comment();
        comment1.setCommentId(2);
        comment1.setPostId(2);
        comment1.setCreateDate(LocalDate.of(2019,11,12));
        comment1.setCommenterName("Neo");
        comment1.setComment("I disagree, this is a horrible take.");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment1);

        doReturn(comment).when(commentClient).getCommentById(1);
        doReturn(commentsByMorpheus).when(commentClient).getCommentsByCommenter("Morpheus");
        doReturn(comments).when(commentClient).getCommentsByPostId(2);
        doReturn(comments).when(commentClient).getAllComments();
    }

    private void setUpPostMock() {
        postClient = mock(PostClient.class);

        Post post = new Post();
        post.setPostId(1);
        post.setPostDate(LocalDate.of(2019, 11, 11));
        post.setPosterName("The Alchemist");
        post.setPost("Let's put Tomi Lahren in a rocket and send her off into space to never return.");

        Post post1 = new Post();
        post1.setPostDate(LocalDate.of(2019, 11, 11));
        post1.setPosterName("The Alchemist");
        post1.setPost("Let's put Tomi Lahren in a rocket and send her off into space to never return.");

        Post post2 = new Post();
        post2.setPostId(2);
        post2.setPostDate(LocalDate.of(2019, 11, 12));
        post2.setPosterName("The Alchemist");
        post2.setPost("My take yesterday was modest. Lets send Laura Ingram too.");


        Post post3 = new Post();
        post3.setPostId(3);
        post3.setPostDate(LocalDate.of(2019,11,12));
        post3.setPosterName("The Alchemist");
        post3.setPost("Throw in pineapple pizza too while you're at it.");

        // ALL POSTS
        List<Post> posts = new ArrayList<>();
        posts.add(post);
        // POSTS BY POSTER
        List<Post> postsByTheAlchemist = new ArrayList<>();
        postsByTheAlchemist.add(post1);
        postsByTheAlchemist.add(post2);

        doReturn(post).when(postClient).createPost(post1);
        doReturn(posts).when(postClient).getPosts();
        doReturn(postsByTheAlchemist).when(postClient).getPostsByPoster("The Alchemist");
        doNothing().when(postClient).deletePost(1);
        doNothing().when(postClient).updatePost(2, post3);
    }
}