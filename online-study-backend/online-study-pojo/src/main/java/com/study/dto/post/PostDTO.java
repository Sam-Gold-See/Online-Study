package com.study.dto.post;

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

    // 帖子标题
    private String title;

    // 帖子内容
    private String content;

    // 帖子种类id
    private Integer categoryId;
}
