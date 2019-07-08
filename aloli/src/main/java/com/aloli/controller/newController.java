package com.aloli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@ResponseBody
	@GetMapping("/ddd{name}/eee{name2}")
	public String request3(@PathVariable String name,@PathVariable String name2) {
		System.out.println(name);
		return name+name2;
				//return listStudent;
	}
	@RequestMapping("/newx")
	public String newx() {
		return "newx";
		//return listStudent;
	}
}
