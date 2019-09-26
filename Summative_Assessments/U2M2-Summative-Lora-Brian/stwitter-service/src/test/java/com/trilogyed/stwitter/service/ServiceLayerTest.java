package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import org.junit.Before;

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

    private void setUpCommentMock() {
        commentClient = mock(CommentClient.class);
    }

    private void setUpPostMock() {
        postClient = mock(PostClient.class);
    }
}