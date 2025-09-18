package org.example.blog_platform.controller;

import lombok.RequiredArgsConstructor;
import org.example.blog_platform.dto.PostRequest;
import org.example.blog_platform.dto.PostResponse;
import org.example.blog_platform.mapper.PostMapper;
import org.example.blog_platform.model.Post;
import org.example.blog_platform.model.User;
import org.example.blog_platform.service.PostService;
import org.example.blog_platform.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.findAll().stream()
                .map(PostMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request, Authentication authentication) {
        String username = authentication.getName();
        User author = userService.findByUsername(username).orElseThrow();
        Post post = postService.createPost(request.getTitle(), request.getContent(), author);
        return ResponseEntity.ok(PostMapper.toDto(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}