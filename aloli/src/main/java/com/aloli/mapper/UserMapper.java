package com.aloli.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.aloli.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;



public interface UserMapper extends BaseMapper<User>{

}
