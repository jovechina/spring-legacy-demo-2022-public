package com.jove.demo.persistence;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jove.demo.models.User;

public interface UserMapper {

	@Select("select * from User where userName = #{userName}")
	public User getUser(@Param(value="userName") String userName);
}
