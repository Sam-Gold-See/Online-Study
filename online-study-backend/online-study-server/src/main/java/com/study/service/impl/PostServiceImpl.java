package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.constant.MessageConstant;
import com.study.context.BaseContext;
import com.study.dto.post.PostDTO;
import com.study.dto.post.PostPageQueryDTO;
import com.study.entity.Post;
import com.study.enumeration.TerminalType;
import com.study.exception.AccountPermissionsException;
import com.study.exception.PostNotFoundException;
import com.study.mapper.PostMapper;
import com.study.result.PageResult;
import com.study.service.PostService;
import com.study.utils.IdUtil;
import com.study.vo.PostVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    /**
     * 新增帖子
     *
     * @param postDTO 帖子新增对象
     */
    @Override
    public void insert(PostDTO postDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);

        Long userId = BaseContext.getCurrentId();
        post.setUserId(userId);

        postMapper.insert(post);
    }

    /**
     * 获取帖子信息
     *
     * @param id 帖子Id
     * @return PostVO帖子VO对象
     */
    @Override
    public PostVO get(Long id) {
        Post post = postMapper.getById(id);

        if (post == null)
            throw new PostNotFoundException(MessageConstant.POST_NOT_FOUND);

        PostVO postVO = new PostVO();
        BeanUtils.copyProperties(post, postVO);

        return postVO;
    }

    /**
     * 修改帖子信息
     *
     * @param postDTO 帖子DTO对象
     */
    @Override
    public void update(PostDTO postDTO) {
        Post post = postMapper.getById(postDTO.getId());
        Long userId = BaseContext.getCurrentId();

        if (!Objects.equals(post.getUserId(), userId))
            throw new AccountPermissionsException(MessageConstant.PERMISSION_DENIED);

        BeanUtils.copyProperties(postDTO, post);
        postMapper.update(post);
    }

    /**
     * 删除帖子
     *
     * @param id 帖子id
     */
    @Override
    public void delete(Long id) {
        Post post = postMapper.getById(id);
        Long userId = BaseContext.getCurrentId();

        if (!Objects.equals(post.getUserId(), userId) && !IdUtil.isAdmin(post.getUserId()))
            throw new AccountPermissionsException(MessageConstant.PERMISSION_DENIED);

        postMapper.update(Post.builder().id(id).status(2).build());
    }

    /**
     * 分页查询
     *
     * @param postPageQueryDTO 帖子分页查询DTO对象
     * @return PageResult类响应对象
     */
    @Override
    public PageResult<PostVO> PageQuery(PostPageQueryDTO postPageQueryDTO, TerminalType terminalType) {
        PageHelper.startPage(postPageQueryDTO.getPage(), postPageQueryDTO.getPageSize());

        Page<PostVO> page = postMapper.getListPage(postPageQueryDTO, terminalType);

        return new PageResult<>(page.getTotal(), page.getResult());
    }
}
