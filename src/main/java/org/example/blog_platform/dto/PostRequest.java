package org.example.blog_platform.dto;

import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String content;
}