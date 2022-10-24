package com.sparta.codecolosseumbackend.controller;


import com.sparta.codecolosseumbackend.dto.request.LogInRequestDto;
import com.sparta.codecolosseumbackend.dto.request.MemberRequestDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입
    @PostMapping("/api/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid MemberRequestDto memberRequestDto) {
        return memberService.registerUser(memberRequestDto);
    }

    //로그인
    @PostMapping("/api/login")
    public ResponseDto<?> login(@RequestBody LogInRequestDto loginRequestDto, HttpServletResponse httpServletResponse) {
        return memberService.login(loginRequestDto, httpServletResponse);
    }
    //로그아웃
}
