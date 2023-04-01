package org.ddestrei.p.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ddestrei.p.model.comment.Comment;
import org.ddestrei.p.model.comment.CommentRequest;
import org.ddestrei.p.model.post.Post;
import org.ddestrei.p.model.post.PostRequest;
import org.ddestrei.p.repository.CommentRepository;
import org.ddestrei.p.repository.PostRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;
    private final CommentRepository commentRepo;
    public void addPost(PostRequest post){
        Post p = new Post();
        p.setContent(post.getContent());
        p.setCreateTime(post.getCreateTime());
        p.setTitle(post.getTitle());
        repository.save(p);
    }

    @Cacheable(cacheNames = "SinglePost", key = "#id")
    public Post findPostById(long id){
        Post post = repository.findById(id).orElse(null);
        if(post == null){
            throw new IllegalArgumentException("Post with this id is not in DB");
        }
        else {
            return post;
        }
    }

    public List<Post> findAll(int page, Sort.Direction sort){
        List<Post> list = repository.findAll(PageRequest.of(page,5, Sort.by(sort,"id"))).toList();
        return list;
    }
    public void addComment(long idPost, CommentRequest comment){
        Post p = repository.findById(idPost).orElse(null);
        if(p==null){
            throw new IllegalArgumentException("Post with this id is not in bd: "+idPost);
        }
        Comment c = new Comment();
        c.setContent(comment.getContent());
        c.setCreateTime(comment.getCreateTime());
        c.setPostId(idPost);
        long commentId=commentRepo.save(c).getId();
        c.setId(commentId);

        p.getComments().add(c);
        repository.save(p);
    }

    @Cacheable(cacheNames = "PostWithComments")
    public List<Post> getWithComments(int page) {
        List<Post> allPost = repository.findAll(PageRequest.of(page,5)).toList();
        List<Long> ids = allPost.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepo.findAllByPostIdIn(ids);
        allPost.forEach(post-> post.setComments(extractComments(comments, post.getId())));
        return allPost;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment-> comment.getPostId().equals(id))
                .collect(Collectors.toList());
    }

    //@CacheEvict(cacheNames = "PostById")
    public void deletePost(long id){
        repository.deleteById(id);
    }
}
