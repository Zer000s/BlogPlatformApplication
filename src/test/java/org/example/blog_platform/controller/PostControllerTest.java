package org.example.blog_platform.controller;

import org.example.blog_platform.model.Post;
import org.example.blog_platform.model.User;
import org.example.blog_platform.service.PostService;
import org.example.blog_platform.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PostControllerTest {
    @Mock
    private PostService postService;
    @Mock
    private UserService userService;

    @InjectMocks
    private PostController postController;

    public PostControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePost() {
        User user = new User();
        user.setUsername("admin");
        Post post = new Post();
        post.setTitle("New Post");

        when(userService.findByUsername("admin")).thenReturn(Optional.of(user));
        when(postService.createPost("New Post", "Content", user)).thenReturn(post);

        ResponseEntity<?> response = postController.createPost(new org.example.blog_platform.dto.PostRequest() {{
            setTitle("New Post");
            setContent("Content");
        }});

        assertEquals(200, response.getStatusCode().value());
        verify(postService, times(1)).createPost("New Post", "Content", user);
    }
}