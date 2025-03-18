package com.study.controller.client;

import com.study.dto.post.PostInsertDTO;
import com.study.result.Result;
import com.study.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ClientPostController")
@RequestMapping("/client/post")
@Slf4j
public class ClientPostController {

    @Autowired
    private PostService postService;

    /**
     * 新增帖子
     *
     * @param postInsertDTO 帖子新增DTO对象
     * @return Result类响应对象
     */
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody PostInsertDTO postInsertDTO) {
        postService.insert(postInsertDTO);
        return Result.success();
    }
}
