package com.study.service.impl;

import com.study.mapper.ClientUserMapper;
import com.study.service.ClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    ClientUserMapper clientUserMapper;
}
