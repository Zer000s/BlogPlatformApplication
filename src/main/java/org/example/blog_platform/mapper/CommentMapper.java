package org.example.blog_platform.mapper;

import org.example.blog_platform.dto.CommentResponse;
import org.example.blog_platform.model.Comment;

public class CommentMapper {
    public static CommentResponse toDto(Comment comment) {
        CommentResponse dto = new CommentResponse();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setAuthor(comment.getAuthor().getUsername());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }
}