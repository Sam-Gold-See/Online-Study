package com.study.service;

import com.study.dto.PostDTO;

public interface PostService {

    /**
     * 新增帖子
     *
     * @param postDTO 帖子DTO对象
     */
    void add(PostDTO postDTO);
}
