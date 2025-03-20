package com.study.service.impl;

import com.study.context.BaseContext;
import com.study.dto.PostDTO;
import com.study.entity.Post;
import com.study.mapper.PostMapper;
import com.study.service.PostService;
import com.study.vo.PostVO;
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
     * @param postDTO 帖子DTO对象
     */
    @Override
    public void add(PostDTO postDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);

        Long userId = BaseContext.getCurrentId();
        post.setUserId(userId);

        postMapper.insert(post);
    }

    /**
     * 获取帖子信息
     *
     * @param id 帖子id
     */
    @Override
    public PostVO get(Long id) {
        Post post = postMapper.getById(id);

        PostVO postVO = new PostVO();
        BeanUtils.copyProperties(post, postVO);

        return postVO;
    }
}
