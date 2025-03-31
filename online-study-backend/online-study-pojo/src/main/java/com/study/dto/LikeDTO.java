package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeDTO implements Serializable {

    // 帖子id
    private Long postId;

    // 评论id
    private Long commentId;
}
