package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.entity.PostCategory;
import com.study.result.Result;
import com.study.service.PostCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/postCategory")
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class PostCategoryController {

    @Autowired
    private PostCategoryService postCategoryService;

    /**
     * 获取全部帖子种类
     */
    @GetMapping
    public Result<List<PostCategory>> getList() {
        List<PostCategory> list = postCategoryService.getList();
        log.info("C端用户(id:{})正在获取全部帖子种类", BaseContext.getCurrentId());
        return Result.success(list);
    }
}
