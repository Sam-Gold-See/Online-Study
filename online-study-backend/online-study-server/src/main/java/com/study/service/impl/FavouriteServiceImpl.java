package com.study.service.impl;

import com.study.mapper.FavouriteMapper;
import com.study.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteMapper favouriteMapper;
}
