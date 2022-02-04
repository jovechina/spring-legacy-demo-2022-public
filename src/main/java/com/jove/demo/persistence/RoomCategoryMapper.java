package com.jove.demo.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Many;

import com.jove.demo.models.RoomCategory;
import com.jove.demo.models.RoomProduct;
import com.jove.demo.models.RoomService;

public interface RoomCategoryMapper {

	@Results({
		@Result(property = "categoryId", column = "key"),
		@Result(property = "categoryName", column = "value"),
		@Result(property = "roomServices", javaType = List.class, column = "key", 
				many = @Many(select = "com.jove.demo.persistence.RoomCategoryMapper.selectServicesByRoomTypeId"))
	})	
	@Select("Select * from codemaster where category = 2")
	public List<RoomCategory> selectAll();
	
	@Results({
		@Result(property = "serviceId", column = "serviceid"),
		@Result(property = "serviceName", column = "servicename"),
		@Result(property = "serviceShortName", column = "serviceshortname"),
		@Result(property = "roomProducts", javaType = List.class, column = "serviceid", 
				many = @Many(select = "com.jove.demo.persistence.RoomCategoryMapper.selectProductsByServiceId"))
	})
	@Select("Select * from roomservice where categoryid = #{categoryid} ")
	public List<RoomService> selectServicesByRoomTypeId(int categoryid );
	
	@Select("Select * from roomproduct where serviceid = #{serviceid}")
	public List<RoomProduct> selectProductsByServiceId(int serviceid);	

}
