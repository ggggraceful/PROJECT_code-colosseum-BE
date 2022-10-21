package com.sparta.codecolosseumbackend.service;

import com.sparta.codecolosseumbackend.dto.request.CommentRequestDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Service
public class CommentService {

	// comment 작성하기
	public ResponseDto<?> createComment(){
		return null;
	}
}
