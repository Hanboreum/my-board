package com.example.myboard.board.service;

import com.example.myboard.board.db.BoardEntity;
import com.example.myboard.board.model.BoardDto;
import com.example.myboard.post.service.PostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardConverter {
    //postList를 바꿔줘야하는데 -> PostConverter
    private final PostConverter postConverter;

    //BoardEntity 가 들어오면 BoardDto로 바꿔준다.
    public BoardDto toDto(BoardEntity boardEntity){

        // entity를 dto로 바꿔준다.
        var postList = boardEntity.getPostList()
                .stream()
                .map(postConverter::toDto)
                .collect(Collectors.toList());

        //이 코드는 BoardEntity 객체에서 getPostList() 메서드를 사용하여 게시물 리스트를 가져온 후,
        // 이를 스트림으로 변환합니다.
        // 그런 다음 각 게시물에 대해 postConverter::toDto 메서드를 사용하여
        // DTO(Data Transfer Object)로 변환하고,
        // 이를 모두 리스트로 수집합니다.
        return BoardDto.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .postList(postList)
                .build();

    }
}
