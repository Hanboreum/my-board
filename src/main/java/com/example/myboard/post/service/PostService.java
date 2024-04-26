package com.example.myboard.post.service;

import com.example.myboard.post.db.PostEntity;
import com.example.myboard.post.db.PostRepository;
import com.example.myboard.post.model.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public PostEntity create(PostRequest postRequest) {
        var entity = PostEntity.builder()
                .boardId(1L) //임시 고정값
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .status("REGISTERED") //등록됨
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();

        return postRepository.save(entity);
    }

}
