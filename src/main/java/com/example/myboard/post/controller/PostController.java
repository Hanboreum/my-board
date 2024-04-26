package com.example.myboard.post.controller;

import com.example.myboard.post.db.PostEntity;
import com.example.myboard.post.model.PostRequest;
import com.example.myboard.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public PostEntity create(@Valid @RequestBody PostRequest postRequest){
        return postService.create(postRequest);
    }
}
