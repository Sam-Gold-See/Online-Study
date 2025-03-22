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
public class CommentDTO implements Serializable {

    // 评论id
    private Long id;

    // 帖子id
    private Long postId;

    // 用户id
    private Long userId;

    // 父评论id
    private Long parentId;

    // 评论内容
    private String content;

    // 评论状态（0=正常，1=删除）
    private Integer status;
}
