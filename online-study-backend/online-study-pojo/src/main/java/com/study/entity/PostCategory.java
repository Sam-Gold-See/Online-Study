package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCategory implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 种类id
    private Integer id;

    // 种类名称
    private String name;
}
