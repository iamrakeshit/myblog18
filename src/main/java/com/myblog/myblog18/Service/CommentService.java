package com.myblog.myblog18.Service;

import com.myblog.myblog18.payload.CommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);

    void deleteComment(long id);

    CommentDto updateComment(long id, CommentDto commentDto, long postId);
}
