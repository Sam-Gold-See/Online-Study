package com.study.service;

import com.study.dto.post.PostDTO;
import com.study.dto.post.PostPageQueryDTO;
import com.study.enumeration.TerminalType;
import com.study.result.PageResult;
import com.study.vo.PostVO;

public interface PostService {

    /**
     * 新增帖子
     *
     * @param postDTO 帖子DTO对象
     */
    void insert(PostDTO postDTO);

    /**
     * 获取帖子信息
     *
     * @param id 帖子Id
     * @return PostVO帖子VO对象
     */
    PostVO get(Long id);

    /**
     * 修改帖子信息
     *
     * @param postDTO 帖子DTO对象
     */
    void update(PostDTO postDTO);

    /**
     * 删除帖子
     *
     * @param id 帖子id
     */
    void delete(Long id);

    /**
     * 分页查询
     *
     * @param postPageQueryDTO 帖子分页查询DTO对象
     * @return PageResult类响应对象
     */
    PageResult<PostVO> PageQuery(PostPageQueryDTO postPageQueryDTO, TerminalType terminalType);

    /**
     * 置顶帖子
     *
     * @param id     帖子id
     * @param type 置顶状态
     */
    void setType(Long id, Integer type);
}
