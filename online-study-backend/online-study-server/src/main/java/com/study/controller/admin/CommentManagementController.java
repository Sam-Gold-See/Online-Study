package com.study.controller.admin;

import com.study.context.BaseContext;
import com.study.entity.Comment;
import com.study.result.Result;
import com.study.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
