package com.blog.blogger.service;

import com.blog.blogger.payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto createPost(PostDto postDto);

public void deletePost(long id);

     public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

     PostDto updatePost(long id, PostDto postDto);
}
