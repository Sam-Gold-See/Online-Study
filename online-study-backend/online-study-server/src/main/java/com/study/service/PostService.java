package com.study.service;

import com.study.dto.post.PostInsertDTO;

public interface PostService {

    /**
     * 新增帖子
     *
     * @param postInsertDTO 帖子新增DTO对象
     */
    void insert(PostInsertDTO postInsertDTO);
}
