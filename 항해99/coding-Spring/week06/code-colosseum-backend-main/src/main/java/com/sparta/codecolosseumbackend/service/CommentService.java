package com.sparta.codecolosseumbackend.service;

import com.sparta.codecolosseumbackend.dto.request.CommentRequestDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;

	// comment 작성하기
	@Transactional
	public ResponseDto<?> createComment(Long problemId, CommentRequestDto commentRequestDto, HttpServletRequest request) {
		return null;
	}

	// comment 불러오기(상세조회)
	@Transactional //(readOnly = true) : 예상치 못한 엔티티의 등록.변경.삭제를 예방, 성능의 최적화
	public ResponseDto<?> getComment(Long problemId) {
		return null;
	}

	// comment 수정하기
	@Transactional
	public ResponseDto<?> updateComment(Long commentId, CommentRequestDto requestDto, HttpServletRequest request) {
		return null;
	}


	// comment 삭제하기
	public ResponseDto<?> deleteComment(Long commentId, HttpServletRequest request) {
		return null;
	}
}
