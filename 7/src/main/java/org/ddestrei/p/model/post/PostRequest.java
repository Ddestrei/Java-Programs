package org.ddestrei.p.model.post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PostRequest {
    private String title;
    private String content;
    private LocalDateTime createTime;
}
