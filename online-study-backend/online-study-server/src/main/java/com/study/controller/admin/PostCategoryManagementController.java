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

    /**
     * 新增帖子种类
     *
     * @param name 帖子种类名称
     */
    @PutMapping("/add")
    public Result<String> add(String name) {
        PostCategory postCategory = postCategoryService.add(name);
        log.info("B端用户(id:{})新增帖子种类:{}", BaseContext.getCurrentId(), postCategory);
        return Result.success();
    }

    /**
     * 删除帖子种类
     *
     * @param id 帖子种类id
     */
    @DeleteMapping("/delete")
    public Result<String> delete(Integer id) {
        PostCategory postCategory = postCategoryService.delete(id);
        log.info("B端用户(id:{})删除帖子种类:{}", BaseContext.getCurrentId(), postCategory);
        return Result.success();
    }
}
