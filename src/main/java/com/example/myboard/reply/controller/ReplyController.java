package com.example.myboard.reply.controller;

import com.example.myboard.reply.db.ReplyEntity;
import com.example.myboard.reply.model.ReplyRequest;
import com.example.myboard.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("")
    public ReplyEntity create( @Valid @RequestBody ReplyRequest replyRequest){
        return replyService.create(replyRequest);

    }
}
