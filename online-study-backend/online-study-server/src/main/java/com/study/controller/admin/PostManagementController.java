package com.study.controller.admin;

import com.study.context.BaseContext;
import com.study.dto.PostDTO;
import com.study.result.Result;
import com.study.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/post")
@RestController
@Slf4j
public class PostManagementController {

    @Autowired
    private PostService postService;

    /**
     * 设置帖子置顶状态
     *
     * @param postDTO 帖子DTO对象
     */
    @PutMapping("/top")
    public Result<String> editTop(@RequestBody PostDTO postDTO) {
        postService.editTop(postDTO);
        log.info("B端用户(id:{})设置帖子(id:{})的置顶状态为:{}", BaseContext.getCurrentId(), postDTO.getId(), postDTO.getTop());
        return Result.success();
    }

    /**
     * 设置帖子加精状态
     *
     * @param postDTO 帖子DTO对象
     */
    @PutMapping("/pro")
    public Result<String> editPro(@RequestBody PostDTO postDTO) {
        postService.editPro(postDTO);
        log.info("B端用户(id:{})设置帖子(id:{})的加精状态为:{}", BaseContext.getCurrentId(), postDTO.getId(), postDTO.getPro());
        return Result.success();
    }

    /**
     * 设置帖子删除状态
     *
     * @param postDTO 帖子DTO对象
     */
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestBody PostDTO postDTO) {
        postService.isDeleted(postDTO);
        log.info("B端用户(id:{})设置帖子(id:{})的删除状态为:{}", BaseContext.getCurrentId(), postDTO.getId(), postDTO.getIsDeleted());
        return Result.success();
    }
}
