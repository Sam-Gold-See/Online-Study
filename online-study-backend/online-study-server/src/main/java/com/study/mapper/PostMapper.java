package com.study.mapper;

import com.github.pagehelper.Page;
import com.study.annotation.AutoFill;
import com.study.dto.PostPageQueryDTO;
import com.study.entity.Post;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import com.study.vo.PostVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PostMapper {

    /**
     * 新增帖子
     *
     * @param post 帖子实体类对象
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO post (user_id, title, content, create_time, update_time, category_id) " +
            "VALUES (#{userId}, #{title}, #{content}, #{createTime}, #{updateTime}, #{categoryId})")
    void insert(Post post);

    /**
     * 通过id获取帖子信息
     *
     * @param id 帖子id
     */
    @Select("SELECT * FROM post WHERE id = #{id}")
    Post getById(Long id);

    /**
     * 动态修改帖子信息
     *
     * @param post 帖子类实体对象
     */
    @AutoFill(operation = OperationType.UPDATE, terminal = TerminalType.CLIENT)
    void update(Post post);

    /**
     * 帖子分页查询
     *
     * @param postPageQueryDTO 帖子分页查询DTO对象
     */
    Page<PostVO> query(PostPageQueryDTO postPageQueryDTO);
}
