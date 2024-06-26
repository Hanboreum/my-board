package com.example.myboard.board.service;

import com.example.myboard.board.db.BoardEntity;
import com.example.myboard.board.db.BoardRepository;
import com.example.myboard.board.model.BoardDto;
import com.example.myboard.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    public BoardDto create(BoardRequest boardRequest){
        var entity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();
        var saveEntity =  boardRepository.save(entity);
        return boardConverter.toDto(saveEntity);
    }

    public BoardDto view(Long id) {
        var entity =boardRepository.findById(id).get();
        return boardConverter.toDto(entity); //converter를 사용해 dto로 바꿔준다.
    }
}
