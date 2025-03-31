package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}
