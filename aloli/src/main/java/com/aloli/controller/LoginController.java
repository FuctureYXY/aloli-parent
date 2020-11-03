package com.aloli.controller;


import com.alibaba.fastjson.JSONObject;
import com.aloli.annotation.login.UserLoginToken;
import com.aloli.entity.User;
import com.aloli.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public String getMessage(){

		return aa();
	}
	@UserLoginToken
	private String  aa(){

		return "aa";
	}
}
