package com.study.service;

import com.study.dto.LikeDTO;

public interface LikeService {

    /**
     * 新增点赞
     *
     * @param likeDTO 点赞DTO对象
     */
    void add(LikeDTO likeDTO);

    /**
     * 删除点赞
     *
     * @param id 点赞id
     */
    void delete(Long id);

    /**
     * 查询点赞情况
     *
     * @param likeDTO 点赞DTO对象
     */
    Integer get(LikeDTO likeDTO);
}
