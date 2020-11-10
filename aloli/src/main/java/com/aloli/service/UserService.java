package com.aloli.service;

import java.util.List;

import com.aloli.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
	  String getToken(User user) ;
	String   useSync();
}
