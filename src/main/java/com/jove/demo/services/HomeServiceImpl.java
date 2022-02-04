package com.jove.demo.services;
 
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jove.demo.models.ContentResult;
import com.jove.demo.persistence.SelectContentMapper;

@Service
public class HomeServiceImpl implements HomeService {
	//private static final Logger logger = LoggerFactory.getLogger(HomeServiceImpl.class);

	@Autowired
	SelectContentMapper selectContentMapper;

	@Override
	public ContentResult init(int id) {

		ContentResult content = selectContentMapper.selectContent(id);

		return content;
	}
}
