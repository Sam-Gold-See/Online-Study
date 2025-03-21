package com.study.service.impl;

import com.study.mapper.PostCategoryMapper;
import com.study.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    @Autowired
    private PostCategoryMapper postCategoryMapper;
}
