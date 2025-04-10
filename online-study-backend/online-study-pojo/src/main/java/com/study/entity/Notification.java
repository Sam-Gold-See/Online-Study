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

    // 发送用户id
    private Long fromId;

    // 接收用户id
    private Long toId;

    // 通知类型（1=点赞，2=评论，3=回复）
    private Integer type;

    // 帖子id
    private Long postId;

    // 评论id
    private Long commentId;

    // 通知内容
    private String content;

    // 是否已读（0=未读，1=已读）
    private Integer status;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}
