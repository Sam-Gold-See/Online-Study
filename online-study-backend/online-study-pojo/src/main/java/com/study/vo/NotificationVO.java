package com.study.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationVO implements Serializable {

    // 通知id
    private Long id;

    // 帖子id
    private Long postId;

    // 评论id
    private Long commentId;

    // 通知内容
    private String content;

    // 创建时间
    private LocalDateTime createTime;
}
