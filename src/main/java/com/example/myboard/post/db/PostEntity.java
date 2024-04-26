package com.example.myboard.post.db;

import com.example.myboard.reply.db.ReplyEntity;
import com.example.myboard.reply.db.ReplyRepository;
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
    private Long boardId;
    private String userName;
    private String password;
    private String status;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime postedAt;

    @Transient //db컬럼으로 인식하지 못하게
    private List<ReplyEntity> replyList = List.of();// 빈 리스트를 기본으로
}
