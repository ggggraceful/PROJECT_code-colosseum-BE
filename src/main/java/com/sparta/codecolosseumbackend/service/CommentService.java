package com.sparta.codecolosseumbackend.service;

import com.sparta.codecolosseumbackend.dto.request.CommentRequestDto;
import com.sparta.codecolosseumbackend.dto.response.CommentResponseDto;
import com.sparta.codecolosseumbackend.dto.response.ResponseDto;
import com.sparta.codecolosseumbackend.entity.Comment;
import com.sparta.codecolosseumbackend.entity.Member;
import com.sparta.codecolosseumbackend.entity.Problem;
import com.sparta.codecolosseumbackend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
//	private final ProblemService problemService;

	// comment 가 존재하는지
	@Transactional // (readOnly = true)
	public Comment isPresentComment(Long commentId){
		Optional<Comment> optionalComment = commentRepository.findById(commentId);
		return optionalComment.orElse(null);
	}

	// comment 작성하기
	@Transactional
	public ResponseDto<?> createComment(Long problemId, CommentRequestDto commentRequestDto, HttpServletRequest request) {

		// 토큰값이 없을 경우
		if (null == request.getHeader("Authorization")) {
			return ResponseDto.fail(HttpStatus.NOT_FOUND, "로그인이 필요합니다.");
		}
		// 존재하지 않는 problemId로 조회하는 경우
//		Problem problem = problemService.isPresentProblem(requestDto.getProblemId());
//		if (null == problem){
//			return ResponseDto.fail(HttpStatus.BAD_REQUEST, "존재하지 않는 문제입니다.");
//		}

		Comment comment = Comment.builder()
			.member(member)
			.problem(problem)
			.content(commentRequestDto.getContent())
			.build();
		commentRepository.save(comment);
		return ResponseDto.success(
			commentRequestDto.builder()
				.id(comment.getId())
				.comment(comment.getContent())
				.nickname(comment.getMember().getNickname())
				.modifiedAt(comment.getModifiedAt())
				.build()
		);
	}


	// comment 불러오기(상세조회)
	@Transactional //(readOnly = true) : 예상치 못한 엔티티의 등록.변경.삭제를 예방, 성능의 최적화
	public ResponseDto<?> getComment(Long problemId) {

		// 존재하지 않는 problemId로 조회하는 경우
//		Problem problem = problemService.isPresentProblem(commentRequestDto.getProblemId());
//		if (null == problem){
//			return ResponseDto.fail(HttpStatus.BAD_REQUEST, "존재하지 않는 문제입니다.");
//		}
		// 존재하지 않는 commentId로 조회하는 경우
		Comment comment = isPresentComment(problemId);
		if (null == comment){
			return ResponseDto.fail(HttpStatus.BAD_REQUEST, "존재하지 않는 댓글입니다.");
		}

		Comment comment = Comment.builder()
				.member(member)
				.problem(problem)
				.content(commentRequestDto.getContent())
				.build();
		commentRepository.save(comment);
		return ResponseDto.success(
				commentRequestDto.builder()
						.id(comment.getId())
						.comment(comment.getContent())
						.nickname(comment.getMember().getNickname())
						.modifiedAt(comment.getModifiedAt())
						.build()
		);

	}


	// comment 수정하기
	@Transactional
	public ResponseDto<?> updateComment(Long commentId, CommentRequestDto requestDto, HttpServletRequest request) {

		// 토큰값이 없을 경우
		if (null == request.getHeader("Authorization")) {
			return ResponseDto.fail(HttpStatus.NOT_FOUND, "로그인이 필요합니다.");
		}
		// 존재하지 않는 problemId로 조회하는 경우
//		Problem problem = problemService.isPresentProblem(commentRequestDto.getProblemId());
//		if (null == problem){
//			return ResponseDto.fail(HttpStatus.BAD_REQUEST, "존재하지 않는 문제입니다.");
//		}
		// 존재하지 않는 commentId로 조회하는 경우
		Comment comment = isPresentComment(commentId);
		if (null == comment){
			return ResponseDto.fail(HttpStatus.BAD_REQUEST, "존재하지 않는 댓글입니다.");
		}

		comment.update(requestDto);
		return ResponseDto.success(
				CommentResponseDto.builder()
						.commentId(comment.getId())
						.comment(comment.getContent())
						.nickname(comment.getMember().getUsername())
						.modifiedAt(comment.getModifiedAt())
						.build()
		);

	}


	// comment 삭제하기
	@Transactional
	public ResponseDto<?> deleteComment(Long commentId, HttpServletRequest request) {

		// 토큰값이 없을 경우
		if (null == request.getHeader("Authorization")) {
			return ResponseDto.fail(HttpStatus.NOT_FOUND, "로그인이 필요합니다.");
		}		// 존재하지 않는 commentId로 조회하는 경우
		Comment comment = isPresentComment(commentId);
		if (null == comment){
			return ResponseDto.fail(HttpStatus.BAD_REQUEST, "존재하지 않는 댓글입니다.");
		}

		commentRepository.delete(comment);
		return ResponseDto.success("success");
	}

}


