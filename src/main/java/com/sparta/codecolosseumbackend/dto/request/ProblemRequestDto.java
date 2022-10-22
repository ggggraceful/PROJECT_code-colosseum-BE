package com.sparta.codecolosseumbackend.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProblemRequestDto {
    private String title;

    private String content;

    private String imgUrl;
}
