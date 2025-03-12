package com.study.service.impl;

import com.study.constant.IdConstant;
import com.study.dto.ClientUserDTO;
import com.study.entity.ClientUser;
import com.study.mapper.ClientUserMapper;
import com.study.service.ClientUserService;
import com.study.utils.IdGeneratorUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    ClientUserMapper clientUserMapper;

    /**
     * 新增C端用户
     *
     * @param clientUserDTO C端用户DTO对象
     */
    @Override
    public void add(ClientUserDTO clientUserDTO) {
         ClientUser clientUser = new ClientUser();
         BeanUtils.copyProperties(clientUserDTO, clientUser);
         clientUser.setPassword(DigestUtils.md5DigestAsHex(clientUserDTO.getPassword().getBytes()));

         Long id = IdGeneratorUtil.generateId(IdConstant.CLIENT_SIGNAL);
         clientUser.setId(id);

         clientUserMapper.insert(clientUser);
    }
}
