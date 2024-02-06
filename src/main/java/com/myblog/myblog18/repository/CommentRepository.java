package com.myblog.myblog18.repository;

import com.myblog.myblog18.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
