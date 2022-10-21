package com.sparta.codecolosseumbackend.service;

import com.sparta.codecolosseumbackend.dto.request.CommentRequestDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.entity.Comment;
import com.sparta.codecolosseumbackend.entity.Member;
import com.sparta.codecolosseumbackend.entity.Problem;
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
	public ResponseDto<?> createComment(CommentRequestDto commentRequestDto, HttpServletRequest request) {
		return null;
	}
}
