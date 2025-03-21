package com.study.mapper;

import com.study.entity.PostCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostCategoryMapper {

    /**
     * 获取全部帖子种类
     */
    @Select("SELECT * FROM post_category")
    List<PostCategory> getList();
}
