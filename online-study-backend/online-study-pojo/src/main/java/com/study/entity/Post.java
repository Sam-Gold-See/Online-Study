package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    // 帖子自增id
    private Long id;

    // C端用户id
    private Long userId;

    // 帖子标题
    private String title;

    // 帖子内容
    private String content;

    // 帖子类型，0=普通，1=置顶
    private Integer type;

    // 帖子状态，0=正常，1=精华，2=拉黑
    private Integer status;

    // 创建时间
    private Date createTime;

    // 热度系数
    private Double score;
}
