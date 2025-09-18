package org.example.blog_platform.repository;

import org.example.blog_platform.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}