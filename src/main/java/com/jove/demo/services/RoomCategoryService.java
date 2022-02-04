package com.jove.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jove.demo.persistence.RoomCategoryMapper;
import com.jove.demo.models.RoomCategory;

@Service
public class RoomCategoryService {

	@Autowired
	RoomCategoryMapper roomCategoryMapper;
	
	public List<RoomCategory> selectAll() {
		return roomCategoryMapper.selectAll();
	}
}
