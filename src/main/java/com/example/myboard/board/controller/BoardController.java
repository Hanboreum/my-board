package com.example.myboard.board.controller;

import com.example.myboard.board.db.BoardEntity;
import com.example.myboard.board.model.BoardDto;
import com.example.myboard.board.model.BoardRequest;
import com.example.myboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public BoardDto create(@Valid @RequestBody BoardRequest boardRequest){
        return boardService.create(boardRequest);
    }


    @GetMapping("/id/{id}")
    public BoardDto view(@PathVariable Long id){
        var entity = boardService.view(id);
        log.info("result: {} ",entity);
        return entity;
    }
}
