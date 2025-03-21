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
}
