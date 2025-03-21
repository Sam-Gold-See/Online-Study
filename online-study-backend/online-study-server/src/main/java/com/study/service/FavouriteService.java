package com.study.service;

import com.study.dto.FavouriteDTO;

public interface FavouriteService {

    /**
     * 新增收藏
     *
     * @param favouriteDTO 收藏DTO对象
     */
    void add(FavouriteDTO favouriteDTO);
}
