package com.study.service;

import com.study.dto.PostDTO;
import com.study.vo.PostVO;

public interface PostService {

    /**
     * 新增帖子
     *
     * @param postDTO 帖子DTO对象
     */
    void add(PostDTO postDTO);

    /**
     * 获取帖子信息
     *
     * @param id 帖子id
     */
    PostVO get(Long id);

    /**
     * 删除帖子
     *
     * @param id 帖子id
     */
    void delete(Long id);

    /**
     * 修改帖子
     *
     * @param postDTO 帖子DTO对象
     */
    void editPost(PostDTO postDTO);
}
