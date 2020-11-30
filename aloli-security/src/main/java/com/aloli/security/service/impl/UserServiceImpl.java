package com.aloli.security.service.impl;

import com.aloli.security.service.DemoMethodService;
import lombok.AllArgsConstructor;
import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.aloli.security.entity.User;
import com.aloli.security.mapper.UserMapper;
import com.aloli.security.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	private DemoMethodService demoMethodService;
	//token的生成方法
	@Override
	public String getToken(User user) {
		String token="";
		token= JWT.create().withAudience(user.getId())
				//sign 加密 采用用户的密码来进行加密
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
	}

	@Override
	public  String   bbx(){
		//demoMethodService.addd("33");
		((UserService)AopContext.currentProxy()).useSync();

		System.out.println("bbxxx");
		return "aa";
	}

	@Async("syncPoolTaskExecutor")
	@Override
	public  String   useSync(){
		try{
			Thread.sleep(3000);
		}catch (Exception e){}

		System.out.println("用来验证事务");
		return "aa";
	}

	@Override
	public  void   testshiwu(User user ){
		User user2 = new User();
		user2.setId("cc");
		user2.setUsername("cc");
	//this.save(user2);
		((UserService)AopContext.currentProxy()).testshiwu2(user);
	//throw new RuntimeException("b");
	}
	@Transactional
	@Override
	public  void   testshiwu2(User user ){
		User user2 = new User();
		user2.setId("cc3");
		user2.setUsername("cc3");
		this.save(user2);
		throw new RuntimeException("b");
	}
}
