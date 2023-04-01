package org.ddestrei.p.controller;

import lombok.RequiredArgsConstructor;
import org.ddestrei.p.service.mapper.PostDtoMapper;
import org.ddestrei.p.model.comment.CommentRequest;
import org.ddestrei.p.model.post.Post;
import org.ddestrei.p.model.post.PostDto;
import org.ddestrei.p.model.post.PostRequest;
import org.ddestrei.p.service.PostService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @GetMapping("/getPagedWithComments")
    public List<Post> getPostWithComments(@RequestParam(value = "page") int page) {
        return service.getWithComments(page);
    }

    @GetMapping("/getSinglePost")
    public Post getSinglePost(@RequestParam long id){
        return service.findPostById(id);
    }

    @GetMapping("/checkToken")
    public String tokenIsWorking(){
        return "Token is working";
    }

    @PostMapping("/add")
    public void addPost(@RequestBody PostRequest post){
        service.addPost(post);
    }

    @GetMapping("/getPaged")
    public List<PostDto> getPagedPost(@RequestParam int page, @RequestParam Sort.Direction sort) {
        return PostDtoMapper.mapPostsToDtos(service.findAll(page, sort));
    }

    @PostMapping("/addComment")
    public void addComment(@RequestParam long id, @RequestBody CommentRequest comment){
        service.addComment(id,comment);
    }

}
