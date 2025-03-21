package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.context.BaseContext;
import com.study.dto.FavouriteDTO;
import com.study.dto.FavouritePageQueryDTO;
import com.study.entity.Favourite;
import com.study.mapper.FavouriteMapper;
import com.study.result.PageResult;
import com.study.service.FavouriteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteMapper favouriteMapper;

    /**
     * 新增收藏
     *
     * @param favouriteDTO 收藏DTO对象
     */
    @Override
    public void add(FavouriteDTO favouriteDTO) {
        Favourite favourite = new Favourite();
        BeanUtils.copyProperties(favouriteDTO, favourite);
        favourite.setUserId(BaseContext.getCurrentId());

        favouriteMapper.insert(favourite);
    }

    /**
     * 删除收藏
     *
     * @param favouriteDTO 收藏DTO对象
     */
    @Override
    public void delete(FavouriteDTO favouriteDTO) {
        Favourite favourite = new Favourite();
        BeanUtils.copyProperties(favouriteDTO, favourite);
        favourite.setUserId(BaseContext.getCurrentId());

        favouriteMapper.delete(favourite);
    }
}
