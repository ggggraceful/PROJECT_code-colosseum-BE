package com.sparta.codecolosseumbackend.controller;

import com.sparta.codecolosseumbackend.dto.request.CommentRequestDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	// comment 작성하기
	@PostMapping("/api/auth/comment/{problemId}")
	public ResponseDto<?> createComment(@RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request){
		return commentService.createComment(commentRequestDto, request);
	}

}
