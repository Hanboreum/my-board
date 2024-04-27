package com.example.myboard.post.db;

import com.example.myboard.board.db.BoardEntity;
import com.example.myboard.reply.db.ReplyEntity;
import com.example.myboard.reply.db.ReplyRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = " post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //
    private Long id;

    //BoardEntity에서 설정한 것에 따라 변경. 객체로 변경된 것
    @ManyToOne //내가 N
    @JsonIgnore //무한생성 없애기,관계 끊어주기
    @ToString.Exclude //log.info  무한 생성 없애기. 관계 끊어주기
    private BoardEntity board; //시스템상 + _id를 붙이기 때문에 board_id가 된다.
    private String userName;
    private String password;
    private String status;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime postedAt;

    @OneToMany(mappedBy = "post")
    private List<ReplyEntity> replyList = List.of();// 빈 리스트를 기본으로
}
