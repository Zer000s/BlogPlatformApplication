package org.example.blog_platform.controller;

import lombok.RequiredArgsConstructor;
import org.example.blog_platform.dto.CommentRequest;
import org.example.blog_platform.dto.CommentResponse;
import org.example.blog_platform.mapper.CommentMapper;
import org.example.blog_platform.model.Post;
import org.example.blog_platform.model.User;
import org.example.blog_platform.service.CommentService;
import org.example.blog_platform.service.PostService;
import org.example.blog_platform.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;
    private final UserService userService;


    @PostMapping("/{postId}")
    public ResponseEntity<CommentResponse> addComment(@PathVariable Long postId, @RequestBody CommentRequest request) {
        Post post = postService.findById(postId).orElseThrow();
        User author = userService.findByUsername("admin").orElseThrow();
        return ResponseEntity.ok(CommentMapper.toDto(commentService.addComment(request.getContent(), author, post)));
    }

    @GetMapping("/{postId}")
    public List<CommentResponse> getComments(@PathVariable Long postId) {
        Post post = postService.findById(postId).orElseThrow();
        return commentService.findByPost(post).stream()
                .map(CommentMapper::toDto)
                .collect(Collectors.toList());
    }
}