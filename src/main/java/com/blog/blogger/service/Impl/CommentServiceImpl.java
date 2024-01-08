package com.blog.blogger.service.Impl;

import com.blog.blogger.Exception.ResourceNotFoundException;
import com.blog.blogger.entity.Comment;
import com.blog.blogger.entity.Post;
import com.blog.blogger.payload.CommentDto;
import com.blog.blogger.repository.CommentRepository;
import com.blog.blogger.repository.PostRepository;
import com.blog.blogger.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id:" + postId)
        );
        Comment comment=new Comment();
        comment.setId(commentDto.getId());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setName(commentDto.getName());

        comment.setPost(post);//it means we are saving comment for this post...

        Comment comment1 = commentRepository.save(comment);
        CommentDto commentDto1=new CommentDto();
        commentDto1.setBody(comment1.getBody());
        commentDto1.setEmail(comment1.getEmail());
        commentDto1.setId(comment1.getId());
        commentDto1.setName(comment1.getName());

        return commentDto1;
    }

    @Override
    public void deleteComment(long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("comment not found with id:" + commentId)
        );
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDto> getCommentByPostId(long postId) {
        List<Comment> byPostId = commentRepository.findByPostId(postId);

        List<CommentDto> commentDtos = byPostId.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return commentDtos;
    }

    @Override
    public CommentDto updateComment(long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("comment not found with id:" + commentId)
        );
       // comment.setId(commentDto.getId());
        comment.setBody(commentDto.getBody());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        Comment comment1 = commentRepository.save(comment);
        CommentDto dto = mapToDto(comment1);
        return dto;

    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> all = commentRepository.findAll();
        List<CommentDto> commentDtos = all.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
        return commentDtos;
    }

    CommentDto mapToDto(Comment comment){
        CommentDto dto=new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setBody(comment.getBody());
        dto.setEmail(comment.getEmail());
        return dto;
    }
}