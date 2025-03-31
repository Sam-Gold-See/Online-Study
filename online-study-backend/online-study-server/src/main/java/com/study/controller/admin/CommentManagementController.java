package com.study.controller.admin;

import com.study.context.BaseContext;
import com.study.dto.CommentDTO;
import com.study.dto.CommentPageQueryDTO;
import com.study.entity.Comment;
import com.study.result.PageResult;
import com.study.result.Result;
import com.study.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/comment")
@Slf4j
public class CommentManagementController {

    @Autowired
    private CommentService commentService;

    /**
     * 查询评论详情
     *
     * @param id 评论id
     */
    @GetMapping()
    public Result<Comment> get(Long id) {
        Comment comment = commentService.get(id);
        log.info("B端用户(id:{})查询评论详情(id:{})", BaseContext.getCurrentId(), id);
        return Result.success(comment);
    }

    /**
     * 分页查询评论
     *
     * @param commentPageQueryDTO 评论分页查询DTO
     */
    @GetMapping("/query")
    public Result<PageResult<Comment>> query(@RequestBody CommentPageQueryDTO commentPageQueryDTO) {
        PageResult<Comment> pageResult = commentService.query(commentPageQueryDTO);
        log.info("B端用户(id:{})分页查询评论", BaseContext.getCurrentId());
        return Result.success(pageResult);
    }

    /**
     * 设置评论可见状态
     *
     * @param commentDTO 评论DTO对象
     */
    @PutMapping("/setDeleted")
    public Result<String> delete(@RequestBody CommentDTO commentDTO) {
        commentService.setDeleted(commentDTO);
        log.info("B端用户(id:{})设置评论可见状态:{}", BaseContext.getCurrentId(), commentDTO);
        return Result.success();
    }
}
