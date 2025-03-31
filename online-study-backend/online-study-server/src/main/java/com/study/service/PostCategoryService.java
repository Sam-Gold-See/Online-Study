package com.study.service;

import com.study.entity.PostCategory;

import java.util.List;

public interface PostCategoryService {

    /**
     * 获取全部帖子种类
     */
    List<PostCategory> getList();

    /**
     * 新增帖子种类
     *
     * @param name 帖子种类名称
     */
    PostCategory add(String name);

    /**
     * 删除帖子种类
     *
     * @param id 帖子种类id
     */
    PostCategory delete(Integer id);

    /**
     * 修改帖子种类
     *
     * @param postCategory 帖子种类实体对象
     */
    void edit(PostCategory postCategory);
}
