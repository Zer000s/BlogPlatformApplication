package org.example.blog_platform.mapper;

import org.example.blog_platform.dto.PostResponse;
import org.example.blog_platform.model.Post;

public class PostMapper {
    public static PostResponse toDto(Post post) {
        PostResponse dto = new PostResponse();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setAuthor(post.getAuthor().getUsername());
        dto.setCreatedAt(post.getCreatedAt());
        return dto;
    }
}