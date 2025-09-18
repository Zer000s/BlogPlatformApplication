package org.example.blog_platform.service;

import lombok.RequiredArgsConstructor;
import org.example.blog_platform.model.Comment;
import org.example.blog_platform.model.Post;
import org.example.blog_platform.model.User;
import org.example.blog_platform.repository.CommentRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;


    public List<Comment> findByPost(Post post) {
        return post.getComments();
    }


    public Comment addComment(String content, User author, Post post) {
        Comment comment = Comment.builder()
                .content(content)
                .author(author)
                .post(post)
                .createdAt(LocalDateTime.now())
                .build();
        return commentRepository.save(comment);
    }
}