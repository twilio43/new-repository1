package com.blog.blogger.service;

import com.blog.blogger.payload.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    public CommentDto createComment(long postId,CommentDto commentDto);

    void deleteComment(long commentId);

    List<CommentDto> getCommentByPostId(long postId);

    CommentDto updateComment(long commentId, CommentDto commentDto);

    List<CommentDto> getAllComments();
}
