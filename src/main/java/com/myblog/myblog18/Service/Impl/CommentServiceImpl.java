package com.myblog.myblog18.Service.Impl;

import com.myblog.myblog18.Service.CommentService;
import com.myblog.myblog18.entity.Comment;
import com.myblog.myblog18.entity.Post;
import com.myblog.myblog18.exception.ResourceNotFoundException;
import com.myblog.myblog18.payload.CommentDto;
import com.myblog.myblog18.repository.CommentRepository;
import com.myblog.myblog18.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    public CommentServiceImpl(PostRepository postRepository,CommentRepository commentRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new ResourceNotFoundException("Post not found with id " + postId)
        );

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setPost(post);

        Comment savedcomment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(savedcomment.getId());
        dto.setContent(savedcomment.getContent());
        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new ResourceNotFoundException("post not found found with id "+ id)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("post not found found with id "+ id)
        );
        Comment c = mapToEntity(commentDto);
        c.setId(comment.getId());
        c.setPost(post);
        Comment savedComment = commentRepository.save(c);
        return mapToDto(savedComment);
    }

    CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }

    Comment mapToEntity(CommentDto commentDto){
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }
}
