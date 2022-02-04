package com.jove.demo.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jove.demo.models.Estimation;

public interface EstimationMapper {

	@Select("Select * from estimation where userId = #{userId}")
	public List<Estimation> selectEstimationByUserId(@Param(value = "userId") int userId);


	@Results({
		@Result(property = "estimationId", column = "estimationid", id=true),
		@Result(property = "userId", column = "userId"),
		@Result(property = "userName", column = "userId", 
				one = @One(select = "com.jove.demo.persistence.UserMapper.selectUserNameById")),
		@Result(property = "roomType", column = "roomId",
				one = @One(select = "com.jove.demo.persistence.RoomTypeMapper.selectRoomType")),
		@Result(property = "interiorDecoration", column = "interiorDecoration",
				one = @One(select = "com.jove.demo.persistence.RoomCategoryMapper.selectRoomCategoryById")),
		@Result(property = "wires", column = "wires",
				one = @One(select = "com.jove.demo.persistence.RoomCategoryMapper.selectProductNameByProductId")),
		@Result(property = "cable", column = "cable",
				one = @One(select = "com.jove.demo.persistence.RoomCategoryMapper.selectProductNameByProductId")),
		@Result(property = "createDate", column = "createdate"),
		@Result(property = "updateDate", column = "updatedate")
		
		
		
	})	
	@Select("Select estimationId,userId,roomId,interiorDecoration,wires,cable, createdate, updatedate from estimation")
	public List<Estimation> selectToSearchResult();
	
	@Select("Select * from estimation")
	public List<Estimation> selectAll();
	
	@Select("Select * from estimation where estimationid = #{estimationId}")
	public Estimation selectEstimationById(@Param(value = "estimationId") int estimationId);
	
	@Insert("insert into estimation(userid, roomid,interiordecoration,paintwall,ceiling,wires,"
			+ "cable,floor,walltiles,tile,kitchencabinet,rangehood,waterpipe,createdate) "
			+ "values(#{userId},#{roomId},#{interiorDecoration},#{paintWall},#{ceiling},#{wires},"
			+ "#{cable},#{floor},#{walltiles},#{tile},#{kitchenCabinet},#{rangeHood},#{waterPipe},"
			+ "#{createDate}) ")
	@Options(useGeneratedKeys = true, keyProperty = "estimationId")
	public boolean insert(Estimation estimation);
	
	@Update("update estimation "
			+ "set userid = #{userId},"
			+ " roomid = #{roomId},"
			+ " interiordecoration = #{interiorDecoration},"
			+ " paintwall = #{paintWall},"
			+ " ceiling = #{ceiling},"
			+ " wires = #{wires},"			
			+ " cable = #{cable},"
			+ " floor = #{floor}," 
			+ " walltiles = #{walltiles},"
			+ " tile = #{tile},"
			+ " kitchencabinet = #{kitchenCabinet},"
			+ " rangehood = #{rangeHood},"
			+ " waterpipe = #{waterPipe},"
			+ " updatedate = #{updateDate}"			
			+ " where  estimationid = #{estimationId}")
	public boolean update(Estimation estimation);
	
	@Delete("DELETE FROM estimation where estimationid = #{estimationId}")
	public boolean delete(int estimationId);

}
