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
public class CommentPageQueryDTO implements Serializable {

    // 帖子id
    private Long postId;

    // 父评论id
    private Long parentId;

    // 用户id
    private Long userId;

    // 评论状态（0=正常，1=删除）
    private Integer status;

    // 页码数
    private Integer page;

    // 每页记录数
    private Integer pageSize;
}
