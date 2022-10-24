package com.sparta.codecolosseumbackend.entity;

import com.sparta.codecolosseumbackend.dto.request.ProblemRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Problem extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    //    public Problem from (Member member, ProblemRequestDto requestDto) {
//        return Problem.builder()
//                .title(requestDto.getTitle())
//                .content(requestDto.getContent())
//                .imgUrl(requestDto.getImgUrl())
//                .member(member)
//                .build();
//    }
    public Problem(Member member, ProblemRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.imgUrl = requestDto.getImgUrl();
        this.member = member;
    }

    // 업데이트
    public void updateProblem(ProblemRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.imgUrl = requestDto.getImgUrl();
    }
}
