package com.jove.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jove.demo.models.Room;
import com.jove.demo.models.User;

@Controller
@SessionAttributes("user")
public class EstimationController {
	
	private static final Logger logger = LoggerFactory.getLogger(EstimationController.class);

	@RequestMapping(value = "/estimation-1", method = RequestMethod.POST)
	public String login(@Validated Room room, Model model) {
		
		User user = (User) model.getAttribute("user");
		logger.debug("token:" + user.getToken());
		logger.debug("password:" + user.getPassword());
		logger.debug("userName:" + user.getUserName());
		logger.debug("roomType:" + room.getRoomType());
		logger.debug("interiorDecoration:" + room.getInteriorDecoration());
		return "estimation-step-2";
	}
}
