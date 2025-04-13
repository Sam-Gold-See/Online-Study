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
        log.info("B端用户(id:{})查询全部帖子种类", BaseContext.getCurrentId());
        List<PostCategory> list = postCategoryService.getList();
        return Result.success(list);
    }

    /**
     * 新增帖子种类
     *
     * @param name 帖子种类名称
     */
    @PutMapping("/add")
    public Result<String> add(String name) {
        log.info("B端用户(id:{})新增帖子种类:{}", BaseContext.getCurrentId(), name);
        postCategoryService.add(name);
        return Result.success();
    }

    /**
     * 删除帖子种类
     *
     * @param id 帖子种类id
     */
    @DeleteMapping("/delete")
    public Result<String> delete(Integer id) {
        log.info("B端用户(id:{})删除帖子种类id:{}", BaseContext.getCurrentId(), id);
        postCategoryService.delete(id);
        return Result.success();
    }

    /**
     * 修改帖子种类
     *
     * @param postCategory 帖子种类实体对象
     */
    @PostMapping("/edit")
    public Result<String> edit(@RequestBody PostCategory postCategory) {
        log.info("B端用户(id:{})修改帖子种类:{}", BaseContext.getCurrentId(), postCategory);
        postCategoryService.edit(postCategory);
        return Result.success();
    }
}
