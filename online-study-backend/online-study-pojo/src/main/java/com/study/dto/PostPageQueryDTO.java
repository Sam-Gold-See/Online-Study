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
public class PostPageQueryDTO implements Serializable {

    // 帖子标题
    private String title;

    // 加精状态，0=普通，1=加精
    private Integer pro;

    // 删除状态，0=正常，1=删除
    private Integer isDeleted;

    // 按浏览数排行
    private Integer viewTop;

    // 按点赞数排行
    private Integer likeTop;

    // 按评论数排行
    private Integer commentTop;

    // 帖子种类Id
    private Integer categoryId;

    // 页码数
    private Integer page;

    // 每页显示记录数
    private Integer pageSize;
}
