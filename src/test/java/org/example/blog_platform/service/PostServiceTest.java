package org.example.blog_platform.service;

import org.example.blog_platform.model.Post;
import org.example.blog_platform.model.User;
import org.example.blog_platform.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    public PostServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePost() {
        User user = new User();
        user.setUsername("testuser");
        Post post = new Post();
        post.setTitle("Test Post");

        when(postRepository.save(any(Post.class))).thenReturn(post);

        Post result = postService.createPost("Test Post", "Content", user);
        assertEquals("Test Post", result.getTitle());
        verify(postRepository, times(1)).save(any(Post.class));
    }


    @Test
    void testFindById() {
        Post post = new Post();
        post.setId(1L);

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        Optional<Post> result = postService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }
}