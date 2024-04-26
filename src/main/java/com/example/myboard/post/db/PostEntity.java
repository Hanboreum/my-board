package com.example.myboard.post.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private int password;
    private String status;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime postedAt;
}
