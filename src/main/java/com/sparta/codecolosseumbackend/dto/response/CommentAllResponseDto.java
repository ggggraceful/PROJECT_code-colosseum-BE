package com.sparta.codecolosseumbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentAllResponseDto {

	private Long commentId;
	private String comment;
	private String nickname;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

}
