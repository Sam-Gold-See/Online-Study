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
public class Notification implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 通知id
    private Long id;

    // 接收用户id
    private Long userId;

    // 通知类型（1=点赞，2=评论，3=回复）
    private Integer type;

    // 来源id（帖子id或评论id）
    private Long sourceId;

    // 是否已读（0=未读，1=已读）
    private Integer isRead;

    // 评论id（评论帖子、回复评论时非空）
    private Long commentId;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}
