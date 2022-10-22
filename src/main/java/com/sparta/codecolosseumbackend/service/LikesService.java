package com.sparta.codecolosseumbackend.service;

import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.entity.Likes;
import com.sparta.codecolosseumbackend.entity.Member;
import com.sparta.codecolosseumbackend.entity.Problem;
import com.sparta.codecolosseumbackend.repository.LikesRepository;
import com.sparta.codecolosseumbackend.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository likesRepository;
    private final ProblemRepository problemRepository;

//    @Transactional
//    public ResponseDto like(Member member, Long postId) {
////        Problem problem = problemRepository.findById(postId).orElseThrow(
////                () -> new RequestException(HttpStatus.NOT_FOUND,"해당 게시글이 존재하지 않습니다.")
////        );
//
//        Problem problem = problemRepository.findById(postId).orElseThrow(
//                () -> new IllegalArgumentException("게시글이 존재하지 않습니다"));
//
//        Optional<Likes> likes = likesRepository.findAllByProblemAndMember(problem, member);
//
//        if(likes.isPresent()) {
//            likesRepository.deleteById(likes.get().getId());
//            return ResponseDto.success(problem.getId() + "번 게시글에 좋아요가 취소되었습니다");
//        } else{
//            Likes memberLike = new Likes(problem,member);
//            likesRepository.save(memberLike);
//            return ResponseDto.success(problem.getId() + "번 게시글에 좋아요가 등록되었습니다");
//        }
//    }

    @Transactional
    public ResponseDto like2(Long postId) {
//        Problem problem = problemRepository.findById(postId).orElseThrow(
//                () -> new RequestException(HttpStatus.NOT_FOUND,"해당 게시글이 존재하지 않습니다.")
//        );

        Problem problem = problemRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다"));

        Optional<Likes> likes = likesRepository.findByProblem(problem);

        if(likes.isPresent()) {
            likesRepository.deleteById(likes.get().getId());
            return ResponseDto.success(problem.getId() + "번 게시글에 좋아요가 취소되었습니다");
        } else{
            Likes memberLike = new Likes(problem);
            likesRepository.save(memberLike);
            return ResponseDto.success(problem.getId() + "번 게시글에 좋아요가 등록되었습니다");
        }
    }


}
