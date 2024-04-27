package com.example.myboard.post.model;

import com.example.myboard.board.db.BoardEntity;
import com.example.myboard.reply.db.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {

     private Long id;
     private Long boardId; //시스템상 + _id를 붙이기 때문에 board_id가 된다.
    private String userName;
    private String password;
    private String status;
    private String title;
    private String content;
    private LocalDateTime postedAt;

}
