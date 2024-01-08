package com.blog.blogger.controller;

import com.blog.blogger.Employee;
import com.blog.blogger.entity.Post;
import com.blog.blogger.payload.PostDto;
import com.blog.blogger.service.PostService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        PostDto dto = postService.createPost(postDto);

        return  new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("post is deleted",HttpStatus.OK);
    }
    //http://localhost:8080/api/posts?pageNo=0&pazeSize=5&sortBy=title&sortDir=asc
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam (name="pageNo",defaultValue="0",required=false) int pageNo,
            @RequestParam (name="pageSize",defaultValue="3",required=false) int pageSize,
            @RequestParam(name = "sortBy",defaultValue = "id",required = false) String sortBy,
            @RequestParam(name="sortDir",defaultValue = "asc",required = false) String sortDir)
    {
        List<PostDto> dtos=postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }
//http://localhost/8080/api/posts?postId=1
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
     public ResponseEntity<PostDto> updatePost(
             @RequestParam("postId") long postId,
             @RequestBody PostDto postDto
    ){
      PostDto post=postService.updatePost(postId,postDto);
      return new ResponseEntity<>(post,HttpStatus.OK);
    }
}
