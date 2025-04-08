package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 接收通知的用户ID
    private Long userId;

    // 通知类型（1=点赞，2=评论，3=回复）
    private Integer type;

    // 来源ID（帖子ID或评论ID）
    private Long sourceId;

    // 仅回复评论时使用
    private Long commentId;
}
