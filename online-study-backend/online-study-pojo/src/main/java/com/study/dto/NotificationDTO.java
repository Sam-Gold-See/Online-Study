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

    // 发送用户id
    private Long fromId;

    // 通知类型（1=点赞，2=评论，3=回复）
    private Integer type;

    // 帖子id
    private Long postId;

    // 评论id
    private Long commentId;
}
