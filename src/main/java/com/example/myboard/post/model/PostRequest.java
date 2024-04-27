package com.example.myboard.post.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequest {

    private Long boardId =1L;

    @NotBlank
    private String userName;
    @NotBlank
    @Size(min = 4, max = 4)
    private String password;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

}
