package com.blog.blogger.service.Impl;

import com.blog.blogger.Exception.ResourceNotFoundException;
import com.blog.blogger.entity.Post;
import com.blog.blogger.payload.PostDto;
import com.blog.blogger.repository.PostRepository;
import com.blog.blogger.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private PostRepository postRepository;


    @Override
    public PostDto createPost(PostDto postDto) {
        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost = postRepository.save(post);
       PostDto dto=new PostDto();
       dto.setId(savedPost.getId());
       dto.setContent(savedPost.getContent());
       dto.setDescription(savedPost.getDescription());
       dto.setTitle(savedPost.getTitle());
        return dto;


    }

    @Override
    public void deletePost(long id) {
        postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id:" + id));
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> all = postRepository.findAll(pageable);
        List<Post> posts = all.getContent();
        List<PostDto> collect = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public PostDto updatePost(long postId, PostDto postDto) {
    Post post=postRepository.findById(postId).orElseThrow(
            ()->new ResourceNotFoundException("Post not found with id:"+postId)
    );


       post.setContent(postDto.getContent());
       post.setTitle(postDto.getTitle());
       post.setDescription(postDto.getDescription());
     Post post1=postRepository.save(post);
        PostDto postDto1 = mapToDto(post1);
        return postDto1;

    }


    //Sort.Direction.ASC ->prints ASC
    PostDto mapToDto(Post post){
        PostDto postDto=new PostDto();
        postDto.setId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        return postDto;
    }
}
