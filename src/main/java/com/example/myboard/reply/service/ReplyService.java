package com.example.myboard.reply.service;

import com.example.myboard.post.db.PostRepository;
import com.example.myboard.reply.db.ReplyEntity;
import com.example.myboard.reply.db.ReplyRepository;
import com.example.myboard.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
   private final ReplyRepository replyRepository;
   private final PostRepository postRepository;

    public ReplyEntity create(ReplyRequest replyRequest){
        var optionalPostEntity = postRepository.findById(replyRequest.getPostId());

        if(optionalPostEntity.isEmpty()){ //null 일 때
            throw  new RuntimeException("게시글이 존재하지 않습니다. "+ replyRequest.getPostId());
        }
        var entity = ReplyEntity.builder()
                .post(optionalPostEntity.get())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status("REGISTERED")
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .repliedAt(LocalDateTime.now())
                .build();
        return replyRepository.save(entity);
    }

    public List<ReplyEntity> findAllByPostId( Long postId){
        return replyRepository.findAllByPostIdAndStatusOrderById(postId, "REGISTERED");
    }
}
