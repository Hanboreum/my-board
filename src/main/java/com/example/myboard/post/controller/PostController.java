package com.example.myboard.post.controller;

import com.example.myboard.post.db.PostEntity;
import com.example.myboard.post.model.PostRequest;
import com.example.myboard.post.model.PostViewRequest;
import com.example.myboard.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public PostEntity create(@Valid @RequestBody PostRequest postRequest){
        return postService.create(postRequest);
    }

    //@GetMapping("/id/{id}")
    @PostMapping("/view") //개별 조회
    public PostEntity view(@Valid @RequestBody PostViewRequest postViewRequest){
        return postService.view(postViewRequest);
    }
    @GetMapping("/all")
    public List<PostEntity> list(){ //List를 뿌려야 하기 떄문에 만듬
        return postService.all();
    }
    @PostMapping("/delete")
    public void delete(
            @Valid
            @RequestBody PostViewRequest postViewRequest
    ){
        postService.delete(postViewRequest);
    }
}
