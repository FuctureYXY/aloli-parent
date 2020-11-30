package com.aloli.security.controller;


import com.alibaba.fastjson.JSONObject;
import com.aloli.annotation.login.UserLoginToken;
import com.aloli.config.res.BussinessException;
import com.aloli.security.entity.User;
import com.aloli.security.entity.vo.UserVo;
import com.aloli.security.service.DemoMethodService;
import com.aloli.security.service.UserService;
import com.aloli.util.ResultCode;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	UserService userService;
	@Autowired
	DemoMethodService demoMethodService;
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
				jsonObject.put("message","登录失败,密码错误");
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

		demoMethodService.addd("aa");


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
	@GetMapping("/getsyncException")
	public String  getsyncException(){
		System.out.println("b");
		userService.bbx();
		System.out.println("b");
		return "aa";
	}
	public void bb(){
		userService.useSync();
	}
	@GetMapping("/getassException")
	public void  getassException( UserVo user){
		User user1 = new User();
		user1.setId("dd222");

		//WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		userService.useSync();
		System.out.println("cc");

		//return "aa";
	}

	@GetMapping("/getshiwu")
	public void  getshiwu( UserVo user){
		User user1 = new User();
		user1.setId("dd222");

		//WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		userService.testshiwu(user1);

	}



}
