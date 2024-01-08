package com.blog.blogger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainUtil {
    public static void main(String[] args) {
        Post post1=new Post();
        post1.setId(1);
        post1.setTitle("aaa");
        post1.setContent("aaaa");

        Post post2=new Post();
        post2.setId(2);
        post2.setTitle("bbb");
        post2.setContent("bbb");

        Post post3=new Post();
        post3.setId(3);
        post3.setTitle("ccc");
        post3.setContent("cccc");

        List<Post> posts=Arrays.asList(post1,post2,post3);
        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());

        for (PostDto p:dtos
             ) {
            System.out.println(p.getId());
            System.out.println(p.getTitle());
            System.out.println(p.getContent());
        }
    }
   static PostDto mapToDto(Post post){
        PostDto  dto=new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        return dto;
    }
}
