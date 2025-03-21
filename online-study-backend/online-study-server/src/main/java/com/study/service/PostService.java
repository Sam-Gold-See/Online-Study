package com.study.service;

import com.study.dto.PostDTO;
import com.study.dto.PostPageQueryDTO;
import com.study.entity.Post;
import com.study.result.PageResult;
import com.study.vo.PostVO;

public interface PostService {

    /**
     * 新增帖子
     *
     * @param postDTO 帖子DTO对象
     */
    void add(PostDTO postDTO);

    /**
     * 获取帖子信息
     *
     * @param id 帖子id
     */
    PostVO get(Long id);

    /**
     * 删除帖子
     *
     * @param id 帖子id
     */
    void delete(Long id);

    /**
     * 修改帖子
     *
     * @param postDTO 帖子DTO对象
     */
    void editPost(PostDTO postDTO);

    /**
     * 帖子分页查询
     *
     * @param postPageQueryDTO 帖子分页查询DTO
     */
    PageResult<PostVO> query(PostPageQueryDTO postPageQueryDTO);

    /**
     * 设置帖子置顶状态
     *
     * @param postDTO 帖子DTO对象
     */
    void editTop(PostDTO postDTO);

    /**
     * 设置帖子加精状态
     *
     * @param postDTO 帖子DTO对象
     */
    void editPro(PostDTO postDTO);

    /**
     * 设置帖子删除状态
     *
     * @param postDTO 帖子DTO对象
     */
    void isDeleted(PostDTO postDTO);

    /**
     * 设置帖子的帖子种类
     *
     * @param postDTO 帖子DTO对象
     */
    void category(PostDTO postDTO);

    /**
     * 分页查询帖子
     *
     * @param postPageQueryDTO 帖子分页查询DTO
     */
    PageResult<Post> adminQuery(PostPageQueryDTO postPageQueryDTO);
}
