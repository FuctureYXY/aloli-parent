package com.aloli.security.service;

import com.aloli.security.api.User;

import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
	  String getToken(User user) ;
	  String   useSync();
	  void   testshiwu(User user);
	String   bbx();
	void   testshiwu2(User user );
}
