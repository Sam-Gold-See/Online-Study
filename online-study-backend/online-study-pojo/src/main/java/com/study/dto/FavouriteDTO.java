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
public class FavouriteDTO implements Serializable {

    // 收藏id
    private Integer id;

    // 用户id
    private Long userId;

    // 帖子id
    private Long postId;
}
