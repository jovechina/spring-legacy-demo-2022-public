package com.jove.demo.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.jove.demo.models.CodeMaster;

public interface  CodeMasterMapper {
	
	@Select("Select * from codemaster where category = #{category}")
	public List<CodeMaster> selectCategory(@Param(value="category") int category);
}
