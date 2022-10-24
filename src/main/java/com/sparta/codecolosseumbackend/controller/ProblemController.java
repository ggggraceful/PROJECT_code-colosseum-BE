package com.sparta.codecolosseumbackend.controller;

import com.sparta.codecolosseumbackend.dto.request.ProblemRequestDto;
import com.sparta.codecolosseumbackend.dto.response.ProblemResponseDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.entity.Member;
import com.sparta.codecolosseumbackend.security.UserDetailImp;
import com.sparta.codecolosseumbackend.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ProblemController {
    private final ProblemService problemService;

    // 글 작성
    @PostMapping("/auth/problem")
    public ResponseDto createProblem(@AuthenticationPrincipal UserDetailImp userDetailImp, @RequestBody ProblemRequestDto requestDto) {
        return problemService.createProblem(userDetailImp.getMember(), requestDto);
    }

    // 전체 목록 조회
    @GetMapping("/problems")
    public ResponseDto getAllProblems() {
        return problemService.findAllProblems();
    }

    // 글 하나 조회
    @GetMapping("problem/{problemId}")
    public ResponseDto getOneProblem(@PathVariable Long problemId) {
        return problemService.findOneProblem(problemId);
    }

    // 글 수정
    @PutMapping("/auth/problem/{problemId}")
    public ResponseDto updateProblem(@AuthenticationPrincipal UserDetailImp userDetailImp, @PathVariable Long problemId, @RequestBody ProblemRequestDto requestDto) {
        return problemService.updateProblem(userDetailImp.getMember(), problemId, requestDto);
    }

    // 글 삭제
    @DeleteMapping("/auth/problem/{problemId}")
    public ResponseDto deleteProblem(@AuthenticationPrincipal UserDetailImp userDetailImp, @PathVariable Long problemId) {
        return problemService.deleteProblem(userDetailImp.getMember(), problemId);
    }
}
