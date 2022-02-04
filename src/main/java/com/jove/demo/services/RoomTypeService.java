package com.jove.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jove.demo.models.RoomType;
import com.jove.demo.persistence.RoomTypeMapper;

@Service
public class RoomTypeService {
	
	@Autowired
	RoomTypeMapper roomTypeMapper;
	
	public List<RoomType> getAll() {
		List<RoomType> roomTypes = roomTypeMapper.selectAll();
		return roomTypes;
	}
	
	public RoomType getOne(int roomId) {
		RoomType roomType = roomTypeMapper.getRoomType(roomId);
		return roomType;
	}
}
