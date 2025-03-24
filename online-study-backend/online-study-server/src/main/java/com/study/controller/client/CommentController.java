package com.study.controller.client;

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
@RequestMapping("/client/comment")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 新增评论
     *
     * @param commentDTO 评论DTO对象
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody CommentDTO commentDTO) {
        commentService.add(commentDTO);
        log.info("C端用户(id:{})新增评论:{}", BaseContext.getCurrentId(), commentDTO);
        return Result.success();
    }

    /**
     * 删除评论
     *
     * @param commentDTO 评论DTO对象
     */
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestBody CommentDTO commentDTO) {
        commentService.delete(commentDTO);
        log.info("C端用户(id:{})删除评论:{}", BaseContext.getCurrentId(), commentDTO);
        return Result.success();
    }

    /**
     * 分页查询帖子评论
     *
     * @param commentPageQueryDTO 评论分页查询DTO
     */
    @GetMapping("/postQuery")
    public Result<PageResult<Comment>> postQuery(@RequestBody CommentPageQueryDTO commentPageQueryDTO) {
        PageResult<Comment> pageResult = commentService.postQuery(commentPageQueryDTO);
        log.info("C端用户(id:{})查询帖子评论:{}", BaseContext.getCurrentId(), commentPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 分页查询评论回复
     *
     * @param commentPageQueryDTO 评论分页查询DTO
     */
    @GetMapping("/commentQuery")
    public Result<PageResult<Comment>> commentQuery(@RequestBody CommentPageQueryDTO commentPageQueryDTO) {
        PageResult<Comment> pageResult = commentService.postQuery(commentPageQueryDTO);
        log.info("C端用户(id:{})查询评论回复:{}", BaseContext.getCurrentId(), commentPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 修改评论
     *
     * @param commentDTO 评论DTO对象
     */
    @PutMapping("/edit")
    public Result<String> edit(@RequestBody CommentDTO commentDTO) {
        commentService.edit(commentDTO);
        log.info("C端用户(id:{})修改评论:{}", BaseContext.getCurrentId(), commentDTO);
        return Result.success();
    }
}
