package com.sparta.codecolosseumbackend.dto.response;

import com.sparta.codecolosseumbackend.entity.Problem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ProblemResponseDto {

    @Getter
    @AllArgsConstructor
    @Builder
    // 전체 목록 조회
    public static class ProblemList {
        private String title;

        private String nickname;

        private String tier;

        private LocalDateTime createdAt;

        private LocalDateTime modifiedAt;

        private Long likeNum;

        public ProblemList(Problem problem, Long likeNum) {
            this.title = problem.getTitle();
            this.nickname = problem.getMember().getNickname();
            this.tier = problem.getMember().getTier();
            this.createdAt = problem.getCreatedAt();
            this.modifiedAt = problem.getModifiedAt();
            this.likeNum = likeNum;
        }
    }

    // 상세 페이지 조회
    @Getter
    @AllArgsConstructor
    @Builder
    public static class ProblemDetail {
        private String title;

        private String content;

        private String imgUrl;

        private String nickname;

        private String tier;

        private LocalDateTime createdAt;

        private LocalDateTime modifiedAt;

        private Long likeNum;

        public ProblemDetail(Problem problem, Long likeNum) {
            this.title = problem.getTitle();
            this.content = problem.getContent();
            this.imgUrl = problem.getImgUrl();
            this.nickname = problem.getMember().getNickname();
            this.tier = problem.getMember().getTier();
            this.createdAt = problem.getCreatedAt();
            this.modifiedAt = problem.getModifiedAt();
            this.likeNum = likeNum;
        }
    }
}
