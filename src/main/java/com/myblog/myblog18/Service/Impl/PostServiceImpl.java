package com.myblog.myblog18.Service.Impl;

import com.myblog.myblog18.Service.PostService;
import com.myblog.myblog18.entity.Post;
import com.myblog.myblog18.payload.PostDto;
import com.myblog.myblog18.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public PostDto createRegistration(PostDto postDto) {
        Post post = new Post();
        post.setName(postDto.getName());
        post.setEmail(postDto.getEmail());

        Post spost = postRepository.save(post);

        PostDto dto = new PostDto();
        dto.setId(spost.getId());
        dto.setName(spost.getName());
        dto.setEmail(spost.getEmail());
        return dto;
    }
}
