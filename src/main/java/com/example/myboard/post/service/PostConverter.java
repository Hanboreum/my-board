package com.example.myboard.post.service;

import com.example.myboard.post.db.PostEntity;
import com.example.myboard.post.model.PostDto;
import org.springframework.stereotype.Service;

@Service
public class PostConverter {

    public PostDto toDto(PostEntity postEntity){
        return PostDto.builder()
                .id(postEntity.getId())
                .boardId(postEntity.getBoard().getId())
                .title(postEntity.getTitle())
                .userName(postEntity.getUserName())
                .status(postEntity.getStatus())
                .content(postEntity.getContent())
                .postedAt(postEntity.getPostedAt())
                .build();
    }
}
