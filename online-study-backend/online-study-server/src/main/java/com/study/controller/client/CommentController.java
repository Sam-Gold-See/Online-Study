package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.dto.CommentDTO;
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
    @PutMapping("/add")
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
        log.info("C端用户(id:{})删除评论：{}", BaseContext.getCurrentId(), commentDTO);
        return Result.success();
    }
}
