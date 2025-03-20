package com.study.service.impl;

import com.study.mapper.PostMapper;
import com.study.service.PostService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Mapper
    private PostMapper postMapper;
}
