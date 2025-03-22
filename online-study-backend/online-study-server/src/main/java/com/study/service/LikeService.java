package com.study.service;

import com.study.dto.LikeDTO;

public interface LikeService {

    /**
     * 新增点赞
     *
     * @param likeDTO 点赞DTO对象
     */
    void add(LikeDTO likeDTO);
}
