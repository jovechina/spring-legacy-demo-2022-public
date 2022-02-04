package com.jove.demo.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jove.demo.models.RoomType;

public interface RoomTypeMapper {

	@Select("Select * from roomtype where roomId = #{roomId}")
	public RoomType getRoomType(@Param("roomId") int roomId); 
	
	
	@Select("Select roomtype from roomtype where roomId = #{roomId}")
	public String selectRoomType(int roomId); 
	
	@Select("Select * from roomtype")
	public List<RoomType> selectAll();
	
	

	
}
