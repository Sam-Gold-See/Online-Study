package com.study.service;

import com.study.dto.FavouriteDTO;
import com.study.dto.FavouritePageQueryDTO;
import com.study.entity.Favourite;
import com.study.result.PageResult;

public interface FavouriteService {

    /**
     * 新增收藏
     *
     * @param favouriteDTO 收藏DTO对象
     */
    void add(FavouriteDTO favouriteDTO);

    /**
     * 删除收藏
     *
     * @param favouriteDTO 收藏DTO对象
     */
    void delete(FavouriteDTO favouriteDTO);

    /**
     * 分页查询
     *
     * @param favouritePageQueryDTO 收藏分页查询DTO对象
     */
    PageResult<Favourite> query(FavouritePageQueryDTO favouritePageQueryDTO);
}
