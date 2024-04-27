package com.example.myboard.board.db;

import com.example.myboard.post.db.PostEntity;
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
@Entity(name = " board") //db의 board table과 매칭
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)

public class BoardEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //
    private Long id;
    private String boardName;
    private String status;

    @OneToMany(mappedBy = "board") //1:N 관계를 나타내는 것.
    //board는 postEntity에 있는 변수를 나타낸다.
    //board 를 select하게 되면 postEntity가 내려오게 된다.
    private List<PostEntity> postList = List.of();

}
