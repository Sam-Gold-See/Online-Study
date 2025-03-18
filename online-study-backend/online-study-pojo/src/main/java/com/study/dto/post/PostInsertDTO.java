package com.study.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostInsertDTO {

    // C端用户id
    private Long userId;

    // 帖子标题
    private String title;

    // 帖子内容
    private String content;

    // 创建时间
    private Date createTime;
}
