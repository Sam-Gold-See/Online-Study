package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.constant.MessageConstant;
import com.study.constant.PostConstant;
import com.study.context.BaseContext;
import com.study.dto.PostDTO;
import com.study.dto.PostPageQueryDTO;
import com.study.entity.Post;
import com.study.exception.OperationException;
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

    /**
     * 删除帖子
     *
     * @param id 帖子id
     */
    @Override
    public void delete(Long id) {
        Post post = postMapper.getById(id);
        Long userId = BaseContext.getCurrentId();

        if (!Objects.equals(post.getUserId(), userId) && !IdUtil.isAdmin(post.getUserId())) {
            throw new OperationException(MessageConstant.PERMISSION_ERROR);
        }

        postMapper.update(Post.builder()
                .id(id)
                .isDeleted(PostConstant.DELETED)
                .build());
    }

    /**
     * 修改帖子
     *
     * @param postDTO 帖子DTO对象
     */
    @Override
    public void editPost(PostDTO postDTO) {
        Post post = postMapper.getById(postDTO.getId());
        Long userId = BaseContext.getCurrentId();

        if (!Objects.equals(post.getUserId(), userId) && !IdUtil.isAdmin(post.getUserId())) {
            throw new OperationException(MessageConstant.PERMISSION_ERROR);
        }

        postMapper.update(Post.builder()
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .categoryId(postDTO.getCategoryId())
                .build());
    }

    /**
     * 帖子分页查询
     *
     * @param postPageQueryDTO 帖子分页查询DTO
     */
    @Override
    public PageResult<PostVO> query(PostPageQueryDTO postPageQueryDTO) {
        PageHelper.startPage(postPageQueryDTO.getPage(), postPageQueryDTO.getPageSize());

        Page<PostVO> page = postMapper.query(postPageQueryDTO);

        return new PageResult<>(page.getTotal(), page.getResult());
    }

    /**
     * 设置帖子置顶状态
     *
     * @param postDTO 帖子DTO对象
     */
    @Override
    public void editTop(PostDTO postDTO) {
        Post post = Post.builder()
                .id(postDTO.getId())
                .top(postDTO.getTop())
                .build();
        postMapper.update(post);
    }

    /**
     * 设置帖子加精状态
     *
     * @param postDTO 帖子DTO对象
     */
    @Override
    public void editPro(PostDTO postDTO) {
        Post post = Post.builder()
                .id(postDTO.getId())
                .pro(postDTO.getPro())
                .build();
        postMapper.update(post);
    }

    /**
     * 设置帖子删除状态
     *
     * @param postDTO 帖子DTO对象
     */
    @Override
    public void isDeleted(PostDTO postDTO) {
        Post post = Post.builder()
                .id(postDTO.getId())
                .isDeleted(postDTO.getIsDeleted())
                .build();
        postMapper.update(post);
    }

    /**
     * 设置帖子的帖子种类
     *
     * @param postDTO 帖子DTO对象
     */
    @Override
    public void category(PostDTO postDTO) {
        Post post = Post.builder()
                .id(postDTO.getId())
                .categoryId(postDTO.getCategoryId())
                .build();
        postMapper.update(post);
    }

    /**
     * 分页查询帖子
     *
     * @param postPageQueryDTO 帖子分页查询DTO
     */
    @Override
    public PageResult<Post> adminQuery(PostPageQueryDTO postPageQueryDTO) {
        PageHelper.startPage(postPageQueryDTO.getPage(), postPageQueryDTO.getPageSize());

        Page<Post> page = postMapper.adminQuery(postPageQueryDTO);

        return new PageResult<>(page.getTotal(), page.getResult());
    }
}
