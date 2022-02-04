package com.jove.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jove.demo.models.CodeMaster;
import com.jove.demo.models.Estimation;
import com.jove.demo.models.Room;
import com.jove.demo.models.RoomCategory;
import com.jove.demo.models.User;
import com.jove.demo.services.CodeMasterService;
import com.jove.demo.services.RoomCategoryService;

@Controller
@SessionAttributes("user")
public class EstimationController {
	
	private static final Logger logger = LoggerFactory.getLogger(EstimationController.class);

	@Autowired
	CodeMasterService codeMasterService;
	
	@Autowired
	RoomCategoryService roomCategoryService;
	
	@RequestMapping(value = "/estimation-1", method = RequestMethod.POST)
	public String login(@Validated Room room, Model model) {
		
		User user = (User) model.getAttribute("user");
		logger.debug("token:" + user.getToken());
		logger.debug("roomType:" + room.getRoomType());
		logger.debug("interiorDecoration:" + room.getInteriorDecoration());
		
		Estimation estimation = new Estimation();
		estimation.setRoomId( Integer.parseInt(room.getRoomType()));
		
		// 装修服务
		List<RoomCategory> roomCategories = roomCategoryService.selectAll();
		
		model.addAttribute("roomCategories",roomCategories);
		model.addAttribute("estimation",estimation);
		return "estimation-step-2";
	}
}
