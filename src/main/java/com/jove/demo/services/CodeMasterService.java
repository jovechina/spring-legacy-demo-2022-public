package com.jove.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jove.demo.models.CodeMaster;
import com.jove.demo.persistence.CodeMasterMapper;

@Service
public class CodeMasterService {
	@Autowired
	CodeMasterMapper codeMasterMapper;
	
	public List<CodeMaster> getByCategory(int category) {
		List<CodeMaster> codeMasters = codeMasterMapper.selectCategory(category);
		return codeMasters;
	}
		
}
