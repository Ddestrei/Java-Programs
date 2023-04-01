package org.ddestrei.p.model.comment;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private String content;
    private LocalDateTime createTime;
}
