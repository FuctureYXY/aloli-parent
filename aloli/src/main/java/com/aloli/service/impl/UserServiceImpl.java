package com.aloli.service.impl;

import org.springframework.scheduling.annotation.Async;
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
				//sign 加密 采用用户的密码来进行加密
                .sign(Algorithm.HMAC256(user.getPassword()));

        return token;
	}
	@Async("syncPoolTaskExecutor")
	@Override
	public  String   useSync(){

		System.out.println("用来验证事务");

		return "aa";
	}

}
