package com.blog.blogger.controller;

import com.blog.blogger.payload.CommentDto;
import com.blog.blogger.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestParam(name = "postId") long id, @RequestBody CommentDto commentDto){
       CommentDto dto = commentService.createComment(id,commentDto);

       return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>("comment is deleted",HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentDto>> getCommentByPostId(@PathVariable long postId){
        List<CommentDto> comments = commentService.getCommentByPostId(postId);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable long commentId,@RequestBody CommentDto commentDto){
        CommentDto dto= commentService.updateComment(commentId,commentDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments(){
        List<CommentDto> comments=commentService.getAllComments();
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

}
