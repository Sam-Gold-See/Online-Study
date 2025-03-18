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
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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

    // 帖子状态，0=正常，1=精华，2=隐藏
    private Integer status;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    // 热度系数
    private Double score;

    // 帖子种类Id
    private Integer categoryId;
}
