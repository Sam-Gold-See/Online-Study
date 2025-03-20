package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO implements Serializable {

    // 帖子自增id
    private Long id;

    // C端用户id
    private Long userId;

    // 帖子标题
    private String title;

    // 帖子内容
    private String content;

    // 置顶状态，0=普通，1=置顶
    private Integer top;

    // 加精状态，0=普通，1=加精
    private Integer pro;

    // 删除状态，0=正常，1=删除
    private Integer isDeleted;

    // 帖子种类Id
    private Integer categoryId;
}
