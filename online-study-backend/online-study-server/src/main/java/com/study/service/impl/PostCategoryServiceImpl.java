package com.study.service.impl;

import com.study.entity.PostCategory;
import com.study.mapper.PostCategoryMapper;
import com.study.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    @Autowired
    private PostCategoryMapper postCategoryMapper;

    /**
     * 获取全部帖子种类
     */
    @Override
    public List<PostCategory> getList() {
        return postCategoryMapper.getList();
    }

    /**
     * 新增帖子种类
     *
     * @param name 帖子种类名称
     */
    @Override
    public PostCategory add(String name) {
        PostCategory postCategory = PostCategory.builder()
                .name(name)
                .build();
        postCategoryMapper.add(postCategory);
        return postCategory;
    }

    /**
     * 删除帖子种类
     *
     * @param id 帖子种类id
     */
    @Override
    public PostCategory delete(Integer id) {
        PostCategory postCategory = postCategoryMapper.getById(id);
        postCategoryMapper.delete(postCategory);
        return postCategory;
    }
}
