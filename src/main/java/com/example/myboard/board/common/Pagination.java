package com.example.myboard.board.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Pagination {

    private Integer page;// 현재페이지
    private Integer size; //
    private Integer currentElements; //현재 가지고 있는 엘리먼트
    private Integer totalPage;
    private Integer totalElements;
}
