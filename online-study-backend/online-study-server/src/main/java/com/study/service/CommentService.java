package com.study.service;

import com.study.dto.CommentDTO;
import com.study.dto.CommentPageQueryDTO;
import com.study.entity.Comment;
import com.study.result.PageResult;

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

    /**
     * 分页查询帖子评论
     *
     * @param commentPageQueryDTO 评论分页查询DTO
     */
    PageResult<Comment> postQuery(CommentPageQueryDTO commentPageQueryDTO);

    /**
     * 修改评论
     *
     * @param commentDTO 评论DTO对象
     */
    void edit(CommentDTO commentDTO);

    /**
     * 查询评论详情
     *
     * @param id 评论id
     */
    Comment get(Long id);
}
