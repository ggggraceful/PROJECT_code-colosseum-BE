package com.sparta.codecolosseumbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {

	private Long id;
	private String comment;
	private String nickname;
	private LocalDateTime modifiedAt;

}