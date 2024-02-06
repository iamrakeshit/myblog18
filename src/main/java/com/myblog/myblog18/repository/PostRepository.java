package com.myblog.myblog18.repository;

import com.myblog.myblog18.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
