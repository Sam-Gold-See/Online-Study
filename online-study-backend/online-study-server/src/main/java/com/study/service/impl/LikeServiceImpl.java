package com.study.service.impl;

import com.study.constant.MessageConstant;
import com.study.context.BaseContext;
import com.study.dto.LikeDTO;
import com.study.entity.Like;
import com.study.exception.OperationException;
import com.study.mapper.LikeMapper;
import com.study.service.LikeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 新增点赞
     *
     * @param likeDTO 点赞DTO对象
     */
    @Override
    public void add(LikeDTO likeDTO) {
        Like like = new Like();
        BeanUtils.copyProperties(likeDTO, like);
        like.setUserId(BaseContext.getCurrentId());

        likeMapper.insert(like);
    }

    /**
     * 删除点赞
     *
     * @param id 点赞id
     */
    @Override
    public void delete(Long id) {
        Like like = likeMapper.getById(id);

        if (!Objects.equals(like.getUserId(), BaseContext.getCurrentId())) {
            throw new OperationException(MessageConstant.INVALID_OPERATION);
        }

        likeMapper.delete(id);
    }
}
