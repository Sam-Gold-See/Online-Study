package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.constant.CommentConstant;
import com.study.constant.MessageConstant;
import com.study.constant.NotificationConstant;
import com.study.context.BaseContext;
import com.study.dto.CommentDTO;
import com.study.dto.CommentPageQueryDTO;
import com.study.dto.NotificationDTO;
import com.study.entity.Comment;
import com.study.exception.OperationException;
import com.study.mapper.CommentMapper;
import com.study.producer.NotificationProducer;
import com.study.result.PageResult;
import com.study.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private NotificationProducer notificationProducer;

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

        Long parentId = comment.getParentId();

        notificationProducer.sendNotificationDTO(
                NotificationDTO.builder()
                        .fromId(BaseContext.getCurrentId())
                        .type(parentId == null ? NotificationConstant.COMMENT : NotificationConstant.REPLY)
                        .postId(comment.getPostId())
                        .commentId(parentId)
                        .build()
        );
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

    /**
     * 分页查询评论
     *
     * @param commentPageQueryDTO 评论分页查询DTO
     */
    @Override
    public PageResult<Comment> query(CommentPageQueryDTO commentPageQueryDTO) {
        PageHelper.startPage(commentPageQueryDTO.getPage(), commentPageQueryDTO.getPageSize());

        Page<Comment> page = commentMapper.query(commentPageQueryDTO);

        return new PageResult<>(page.getTotal(), page.getResult());
    }

    /**
     * 修改评论
     *
     * @param commentDTO 评论DTO对象
     */
    @Override
    public void edit(CommentDTO commentDTO) {
        Comment commentDB = commentMapper.getById(commentDTO.getId());

        if (!Objects.equals(BaseContext.getCurrentId(), commentDB.getUserId())) {
            throw new OperationException(MessageConstant.INVALID_OPERATION);
        }

        commentMapper.update(Comment.builder()
                .id(commentDTO.getId())
                .content(commentDTO.getContent())
                .build());
    }

    /**
     * 查询评论详情
     *
     * @param id 评论id
     */
    @Override
    public Comment get(Long id) {
        return commentMapper.getById(id);
    }

    /**
     * 设置评论可见状态
     *
     * @param commentDTO 评论DTO对象
     */
    @Override
    public void setDeleted(CommentDTO commentDTO) {
        commentMapper.update(Comment.builder()
                .id(commentDTO.getId())
                .status(commentDTO.getStatus())
                .build());
    }
}
