package com.aloli.service.impl;

import org.springframework.stereotype.Service;

import com.aloli.entity.User;
import com.aloli.mapper.UserMapper;
import com.aloli.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	//token的生成方法
	@Override
	public String getToken(User user) {
		String token="";
		token= JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
	}


}
