package com.aloli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aloli.entity.Student;
import com.aloli.mapper.StudentMapper;

@Controller
@RequestMapping("bbb")
public class newController {
	@Autowired
	StudentMapper studentMapper; 
	@ResponseBody
	@RequestMapping("request")
	public List request() {
		List<Student> listStudent = studentMapper.listStudent();
		return listStudent;
	}
	@ResponseBody
	@RequestMapping("/ccc")
	public String request2(String name) {
		if(name.equals("x")) {
			return "1";
		}else {
			return "0";
		}
		//return listStudent;
	}
}
