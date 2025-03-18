package com.study.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostPageQueryDTO {

    // 帖子标题
    String title;

    // 页码数
    Integer page;

    // 每页显示记录数
    Integer pageSize;
}
