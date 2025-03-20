package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.dto.PostDTO;
import com.study.result.Result;
import com.study.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client/post")
@RestController
@Slf4j
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 新增帖子
     *
     * @param postDTO 帖子DTO对象
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody PostDTO postDTO) {
        postService.add(postDTO);
        log.info("C端用户(id：{})新增帖子：{}", BaseContext.getCurrentId(), postDTO);
        return Result.success();
    }
}
