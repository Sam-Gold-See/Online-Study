package com.study.service.impl;

import com.study.context.BaseContext;
import com.study.dto.post.PostInsertDTO;
import com.study.entity.Post;
import com.study.mapper.PostMapper;
import com.study.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    /**
     * 新增帖子
     *
     * @param postInsertDTO 帖子新增DTO对象
     */
    @Override
    public void insert(PostInsertDTO postInsertDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postInsertDTO, post);

        Long userId = BaseContext.getCurrentId();
        post.setUserId(userId);

        postMapper.insert(post);
    }
}
