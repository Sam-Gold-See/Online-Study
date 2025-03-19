package com.study.service.impl;

import com.study.constant.IdConstant;
import com.study.constant.MessageConstant;
import com.study.dto.ClientUserRegistDTO;
import com.study.entity.ClientUser;
import com.study.exception.VerificationErrorException;
import com.study.mapper.ClientUserMapper;
import com.study.service.ClientUserService;
import com.study.utils.CodeUtils;
import com.study.utils.IdUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Objects;

@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    private ClientUserMapper clientUserMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 新增C端用户
     *
     * @param clientUserRegistDTO C端用户注册DTO
     */
    @Override
    public void add(ClientUserRegistDTO clientUserRegistDTO) {
        // 获取用户邮箱和验证码
        String email = clientUserRegistDTO.getEmail();
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(email);
        String verificationCode = clientUserRegistDTO.getVerificationCode();
        verificationCode = CodeUtils.upperLetters(verificationCode);

        // 验证码比对
        if (verificationCodeRedis == null || !Objects.equals(verificationCodeRedis, verificationCode)) {
            throw new VerificationErrorException(MessageConstant.VERIFICATION_CODE_ERROR);
        }

        // 验证码正确，删除 Redis 中的验证码
        stringRedisTemplate.delete(email);

        // 复制数据
        ClientUser clientUser = new ClientUser();
        BeanUtils.copyProperties(clientUserRegistDTO, clientUser);

        // 加密密码
        clientUser.setPassword(DigestUtils.md5DigestAsHex(clientUserRegistDTO.getPassword().getBytes()));

        // 生成唯一ID并赋值
        clientUser.setId(IdUtil.generateId(IdConstant.CLIENT_SIGNAL));

        // 插入数据库
        clientUserMapper.insert(clientUser);
    }
}
