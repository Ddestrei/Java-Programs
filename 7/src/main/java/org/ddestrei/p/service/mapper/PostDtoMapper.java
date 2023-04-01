package org.ddestrei.p.service.mapper;

import org.ddestrei.p.model.post.Post;
import org.ddestrei.p.model.post.PostDto;

import java.util.List;
import java.util.stream.Collectors;

public class PostDtoMapper {

    private PostDtoMapper() {}
    static public List<PostDto> mapPostsToDtos(List<Post> posts) {
        return posts.stream()
                .map(post-> mapPostToDto(post))
                .collect(Collectors.toList());
    }

    static private PostDto mapPostToDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createTime(post.getCreateTime())
                .build();
    }
}
