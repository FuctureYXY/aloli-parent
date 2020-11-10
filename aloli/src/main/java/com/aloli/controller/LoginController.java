package com.aloli.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.aloli.annotation.login.UserLoginToken;
import com.aloli.config.res.BussinessException;
import com.aloli.entity.User;
import com.aloli.entity.vo.UserVo;
import com.aloli.service.UserService;
import com.aloli.util.ResultCode;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import javafx.application.Application;
import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.SocketUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	UserService userService;

	//登录
	@PostMapping
	public Object login(@RequestBody User user){
		JSONObject jsonObject=new JSONObject();
		User userForBase=userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername,user.getUsername()));
		if(userForBase==null){
			jsonObject.put("message","登录失败,用户不存在");
			return jsonObject;
		}else {
			if (!userForBase.getPassword().equals(user.getPassword())){
				jsonObject.put("message","登录失败,密码g'r错误");
				return jsonObject;
			}else {
				String token = userService.getToken(userForBase);
				jsonObject.put("token", token);
				jsonObject.put("user", userForBase);
				return jsonObject;
			}
		}
	}

	@GetMapping("/getMessage")
	public void getMessage(){


	}
	@GetMapping("/getList")
	public List getList(){

		return new ArrayList();
	}

	@GetMapping("/getException")
	public List getException(){
			Integer x = 1/0;
		return new ArrayList();
	}
	@GetMapping("/getRunTimeException")
	public List getRunTimeException(){

		throw  new BussinessException(ResultCode.FAIL);

	}
	@UserLoginToken
	private String  aa(){

		return "aa";
	}


	@GetMapping("/getvadiException")
	public String  getvadiException(@Validated UserVo user){

	return "aa";
	}

	@GetMapping("/getassException")
	@Transactional
	public String  getassException( UserVo user){
		User user1 = new User();
		user1.setId("1122");
		user1.setUsername("aaxxsw");
		user1.setPassword("bb");

		//WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		final String s = userService.useSync();
		System.out.println("cc");
		//userService.save(user1);
		return "aa";
	}


}
