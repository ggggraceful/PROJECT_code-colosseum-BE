package com.sparta.codecolosseumbackend.service;

import com.sparta.codecolosseumbackend.dto.request.ProblemRequestDto;
import com.sparta.codecolosseumbackend.dto.response.ProblemResponseDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.entity.Likes;
import com.sparta.codecolosseumbackend.entity.Member;
import com.sparta.codecolosseumbackend.entity.Problem;
import com.sparta.codecolosseumbackend.repository.LikesRepository;
import com.sparta.codecolosseumbackend.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProblemService {
    private final ProblemRepository problemRepository;
    private final LikesRepository likesRepository;

    // 글 작성
    public ResponseDto<?> createProblem(Member member, ProblemRequestDto requestDto) {
        Problem problem = new Problem(member, requestDto);
        problemRepository.save(problem);
        return ResponseDto.success("등록 완료!");
    }

    // 글 목록 가져오기
    public ResponseDto<?> findAllProblems() {
        List<Problem> problems = problemRepository.findAllByOrderByModifiedAtDesc();
        List<ProblemResponseDto.ProblemList> problemLists = new ArrayList<>();
        for (Problem problem : problems) {
            Long likeNum = (long) likesRepository.findAllByProblem(problem).size();
//            Long commentNum = (long) commentRepository.findAllByProblem(problem).size();
            problemLists.add(new ProblemResponseDto.ProblemList(problem, likeNum));
        }
        return ResponseDto.success(problemLists);
    }

    // 글 하나 가져오기
    public ResponseDto<?> findOneProblem(Long problemId) {
        Problem problem = problemRepository.findById(problemId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다"));
        Long likeNum = (long) likesRepository.findAllByProblem(problem).size();
        ProblemResponseDto.ProblemDetail problemDetail = new ProblemResponseDto.ProblemDetail(problem, likeNum);
        return ResponseDto.success(problemDetail);
    }

    // 글 수정하기
    @Transactional
    public ResponseDto<?> updateProblem(Long problemId, ProblemRequestDto requestDto) {
        Problem problem = problemRepository.findById(problemId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다"));

        problem.updateProblem(requestDto);
        return ResponseDto.success("수정 완료!");
    }

    // 글 삭제하기
    @Transactional
    public ResponseDto<?> deleteProblem(Long problemId) {
        Problem problem = problemRepository.findById(problemId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다"));

        problemRepository.deleteById(problemId);

        // 해당 글의 좋아요도 삭제
        List<Likes> likes = likesRepository.findAllByProblem(problem);
        likesRepository.deleteAll(likes);
        return ResponseDto.success("삭제 완료!");
    }
}
