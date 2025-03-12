package com.study.service.impl;

import com.study.constant.AccountConstant;
import com.study.constant.IdConstant;
import com.study.constant.JwtClaimsConstant;
import com.study.constant.MessageConstant;
import com.study.dto.ClientUserDTO;
import com.study.dto.ClientUserLoginDTO;
import com.study.entity.ClientUser;
import com.study.exception.AccountNotFoundException;
import com.study.exception.AccountStatusException;
import com.study.exception.PasswordErrorException;
import com.study.mapper.ClientUserMapper;
import com.study.properties.JwtProperties;
import com.study.service.ClientUserService;
import com.study.utils.IdGeneratorUtil;
import com.study.utils.JwtUtil;
import com.study.vo.ClientUserLoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    ClientUserMapper clientUserMapper;
    @Autowired
    private JwtProperties jwtProperties;

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

    /**
     * 用户登录
     *
     * @param clientUserLoginDTO C端用户登录DTO对象
     * @return ClientUserLoginVO C端用户登录VO对象
     */
    @Override
    public ClientUserLoginVO login(ClientUserLoginDTO clientUserLoginDTO) {
        String phone = clientUserLoginDTO.getPhone();

        // 根据用户手机号、登录账号查询用户库数据
        ClientUser clientUserDB = clientUserMapper.getByPhone(phone);
        if (clientUserDB == null)
            // 账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);

        if (!Objects.equals(clientUserDB.getStatus(), AccountConstant.ENABLED))
            // 账号被封禁无法登录
            throw new AccountStatusException(MessageConstant.ACCOUNT_LOCKED);

        String password = clientUserLoginDTO.getPassword();
        // 密码加密成暗文，在数据库中密码以暗文形式存储
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        if (!password.equals(clientUserDB.getPassword()))
            // 密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);

        // 生成JWT令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.CLIENT_ID, clientUserDB.getId());
        String authentication = JwtUtil.createJWT(
                jwtProperties.getClientSecretKey(),
                jwtProperties.getClientTtl(),
                claims);

        return ClientUserLoginVO.builder()
                .id(clientUserDB.getId())
                .name(clientUserDB.getName())
                .phone(phone)
                .authentication(authentication)
                .build();
    }
}
