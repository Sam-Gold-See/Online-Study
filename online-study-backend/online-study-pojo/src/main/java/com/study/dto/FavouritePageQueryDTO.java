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
public class FavouritePageQueryDTO implements Serializable {

    // 用户id
    private Integer userId;

    // 页码数
    private Integer page;

    // 每页记录数
    private Integer pageSize;
}
