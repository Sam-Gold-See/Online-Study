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
}
