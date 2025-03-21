package com.study.controller.admin;

import com.study.context.BaseContext;
import com.study.dto.PostDTO;
import com.study.result.Result;
import com.study.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PutMapping("top")
    public Result<String> editTop(@RequestBody PostDTO postDTO) {
        postService.editTop(postDTO);
        log.info("B端用户(id:{})设置帖子(id:{})的置顶状态为:{}", BaseContext.getCurrentId(), postDTO.getId(), postDTO.getTop());
        return Result.success();
    }
}
