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
public class ClientUserPageQueryDTO implements Serializable {

    // 用户名
    private String name;

    // 页码
    private int page;

    // 每页显示记录数
    private int pageSize;
}
