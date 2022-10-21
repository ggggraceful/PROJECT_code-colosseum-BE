package com.sparta.codecolosseumbackend.controller;

import com.sparta.codecolosseumbackend.dto.request.CommentRequestDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	// comment 작성하기
	@PostMapping("/api/auth/comment/{problemId}")
	public ResponseDto<?> createComment(@PathVariable Long problemId, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request){
		return commentService.createComment(problemId,commentRequestDto, request);
	}


	// comment 불러오기(상세조회)
	@GetMapping("/apu/auth/comment/{problemId}")
	public ResponseDto<?> getComment(@PathVariable Long problemId){
		return commentService.getComment(problemId);
	}


}
