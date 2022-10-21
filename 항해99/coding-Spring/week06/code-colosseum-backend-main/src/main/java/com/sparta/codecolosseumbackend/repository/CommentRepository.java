package com.sparta.codecolosseumbackend.repository;

import com.sparta.codecolosseumbackend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findAllByOrderByModifiedAtDesc();
}
