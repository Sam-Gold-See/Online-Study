package com.study.service.impl;

import com.study.mapper.LikeMapper;
import com.study.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
}
