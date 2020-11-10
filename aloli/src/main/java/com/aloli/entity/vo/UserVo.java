package com.aloli.entity.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;


@Data
public class UserVo{
	private String id;

	private String username;
	private String password;

}
