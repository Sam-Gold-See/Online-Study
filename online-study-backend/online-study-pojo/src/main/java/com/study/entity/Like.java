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
public class Like implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 点赞id
    private Long id;

    // 用户id
    private Long userId;

    // 帖子id
    private Long postId;

    // 评论id
    private Long commentId;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}
