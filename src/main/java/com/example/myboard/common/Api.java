package com.example.myboard.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Api<T> {

    private T body;
    private Pagination pagination; //page정보
}
