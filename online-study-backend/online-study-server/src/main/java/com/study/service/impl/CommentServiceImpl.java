package com.study.service.impl;

import com.study.constant.CommentConstant;
import com.study.constant.MessageConstant;
import com.study.context.BaseContext;
import com.study.dto.CommentDTO;
import com.study.entity.Comment;
import com.study.exception.OperationException;
import com.study.mapper.CommentMapper;
import com.study.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 新增评论
     *
     * @param commentDTO 评论DTO对象
     */
    @Override
    public void add(CommentDTO commentDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setUserId(BaseContext.getCurrentId());

        commentMapper.insert(comment);
    }

    /**
     * 删除评论
     *
     * @param commentDTO 评论DTO对象
     */
    @Override
    public void delete(CommentDTO commentDTO) {
        Comment commentDB = commentMapper.getById(commentDTO.getId());
        if (!Objects.equals(BaseContext.getCurrentId(), commentDB.getUserId())) {
            throw new OperationException(MessageConstant.INVALID_OPERATION);
        }

        commentMapper.update(Comment.builder()
                .id(commentDB.getId())
                .status(CommentConstant.DELETED)
                .build());
    }
}
