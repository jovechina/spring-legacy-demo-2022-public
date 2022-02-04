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

	// 住宅大分类
	@Results({
		@Result(property = "categoryId", column = "key"),
		@Result(property = "categoryName", column = "value"),
		@Result(property = "roomServices", javaType = List.class, column = "key", 
				many = @Many(select = "com.jove.demo.persistence.RoomCategoryMapper.selectServicesByRoomTypeId"))
	})	
	@Select("Select * from codemaster where category = 2")
	public List<RoomCategory> selectAll();
	
	//装修状况
	@Select("Select value from codemaster where category = 1 and `key` = #{id}")
	public String selectRoomCategoryById(int id);
	
	// 服务
	@Results({
		@Result(property = "serviceId", column = "serviceid"),
		@Result(property = "serviceName", column = "servicename"),
		@Result(property = "serviceShortName", column = "serviceshortname"),
		@Result(property = "roomProducts", javaType = List.class, column = "serviceid", 
				many = @Many(select = "com.jove.demo.persistence.RoomCategoryMapper.selectProductsByServiceId"))
	})
	@Select("Select * from roomservice where categoryid = #{categoryId} ")
	public List<RoomService> selectServicesByRoomTypeId(int categoryId );
	
	// 产品
	@Select("Select * from roomproduct where serviceid = #{serviceId}")
	public List<RoomProduct> selectProductsByServiceId(int serviceId);	
	
	// 产品名称
	@Select("Select productname from roomproduct where productid = #{productId}")
	public String selectProductNameByProductId(int productId);	

}
