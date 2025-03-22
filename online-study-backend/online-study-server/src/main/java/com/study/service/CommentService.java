package com.study.service;

import com.study.dto.CommentDTO;

public interface CommentService {

    /**
     * 新增评论
     *
     * @param commentDTO 评论DTO对象
     */
    void add(CommentDTO commentDTO);

    /**
     * 删除评论
     *
     * @param commentDTO 评论DTO对象
     */
    void delete(CommentDTO commentDTO);
}
