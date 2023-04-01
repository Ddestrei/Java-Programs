package org.ddestrei.p.model.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ddestrei.p.model.comment.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createTime;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "postId",updatable = false, insertable = false)
    private List<Comment> comments;

}
