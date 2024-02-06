package com.myblog.myblog18.Service;

import com.myblog.myblog18.payload.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostDto createRegistration(PostDto postDto);
}
