package com.study.controller.admin;

import com.study.context.BaseContext;
import com.study.entity.PostCategory;
import com.study.result.Result;
import com.study.service.PostCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin/postCategory")
public class PostCategoryManagementController {

    @Autowired
    private PostCategoryService postCategoryService;

    /**
     * 获取全部帖子种类
     */
    @GetMapping
    public Result<List<PostCategory>> getList() {
        List<PostCategory> list = postCategoryService.getList();
        log.info("B端用户(id:{})查询全部帖子种类", BaseContext.getCurrentId());
        return Result.success(list);
    }
}
