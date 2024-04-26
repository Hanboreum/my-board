package com.example.myboard.board.controller;

import com.example.myboard.board.db.BoardEntity;
import com.example.myboard.board.model.BoardRequest;
import com.example.myboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public BoardEntity create(@Valid @RequestBody BoardRequest boardRequest){
        return boardService.create(boardRequest);
    }
}
