package com.study.service;

import com.study.dto.post.PostDTO;
import com.study.vo.PostVO;

public interface PostService {

    /**
     * 新增帖子
     *
     * @param postDTO 帖子DTO对象
     */
    void insert(PostDTO postDTO);

    /**
     * 获取帖子信息
     *
     * @param id 帖子Id
     * @return PostVO帖子VO对象
     */
    PostVO get(Long id);

    /**
     * 修改帖子信息
     *
     * @param postDTO 帖子DTO对象
     */
    void update(PostDTO postDTO);
}
