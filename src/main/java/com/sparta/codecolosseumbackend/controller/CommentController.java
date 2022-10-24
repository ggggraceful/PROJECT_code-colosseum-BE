package com.sparta.codecolosseumbackend.controller;

import com.sparta.codecolosseumbackend.dto.request.CommentRequestDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.hibernate.criterion.Projections.id;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	// comment 작성하기
	@PostMapping("/api/auth/comment/{problemId}")
	public ResponseDto<?> createComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, HttpServletRequest request) {
		return commentService.createComment(id, requestDto, request);
	}

	// comment 불러오기(한문제의 comment 전부)
	@GetMapping("/api/auth/comment/{problemId}")
	public ResponseDto<?> getComment(@PathVariable Long id) {
		return commentService.getComment(id);
	}

	// comment 수정하기
	@PutMapping("/api/auth/comment/{commentId}")
	public ResponseDto<?> updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto, HttpServletRequest request) {
		return commentService.updateComment(commentId, requestDto, request);
	}

	// comment 삭제하기
	@DeleteMapping("/api/auth/comment/{commentId}")
	public ResponseDto<?> deleteComment(@PathVariable Long commentId, HttpServletRequest request){
		return commentService.deleteComment(commentId, request);
	}

}