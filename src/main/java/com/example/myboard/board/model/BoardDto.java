package com.example.myboard.board.model;

import com.example.myboard.post.db.PostEntity;
import com.example.myboard.post.model.PostDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardDto {

    private Long id;
    private String boardName;
    private String status;
    private List<PostDto> postList = List.of();

}
