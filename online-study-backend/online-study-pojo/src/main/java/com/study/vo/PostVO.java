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
public class PostVO implements Serializable {

    // 帖子自增id
    private Long id;

    // C端用户id
    private Long userId;

    // 帖子标题
    private String title;

    // 帖子内容
    private String content;

    // 加精状态，0=普通，1=加精
    private Integer pro;

    // 浏览数
    private Integer viewCount;

    // 点赞数
    private Integer likeCount;

    // 评论数
    private Integer commentCount;

    // 更新时间
    private LocalDateTime updateTime;

    // 帖子种类Id
    private Long categoryId;
}
