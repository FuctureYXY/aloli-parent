package com.aloli.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.aloli.entity.Student;


public interface StudentMapper {
	public List<Student> listStudent();
}
