package com.jove.demo.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jove.demo.models.ContentResult;
import com.jove.demo.models.User;
import com.jove.demo.services.HomeService;
import com.jove.demo.services.UserService;

/**
 * Handles requests for the application home page.
 */
@SessionAttributes({ "user", "estimation" })
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		User user = (User) model.getAttribute("user");
		if (user == null || user.getUserName() == null || user.getUserName().equals("")) {
			user = new User();
			model.addAttribute("user", user);
			return "home";
		} else {
			return estimationController.estimationStepOneInit(model);
		}
	}

	@Autowired
	UserService userService;
	
	@Autowired
	private EstimationController estimationController;	

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@Validated User user, BindingResult result, Model model) {

		// 表单验证，确认输入是否符合要求
		if (result.hasErrors()) {
			logger.info("Inputed contents in form have errors.");
			logger.debug("userName: " + user.getUserName());
			logger.debug("password: " + user.getPassword());
			return "home";
		}

		// 服务端验证，确认用户是否存在。
		user = userService.validatelogin(user);
		logger.debug(user.getToken());
		if (user.getToken() == null || user.getToken() == "") {
			logger.debug("login failed");
			result.reject("error.loginerror", "用户名密码不正确，请重新输入。");
			model.addAttribute("user", user);
			return "home";
		} else {
			model.addAttribute("user", user);
		}

		return estimationController.estimationStepOneInit(model);

	}

	@Autowired
	HomeService homeService;

	@RequestMapping(value = "/test-db/{id}", method = RequestMethod.GET)
	public String content(@PathVariable int id, Model model) {
		ContentResult contentResult = homeService.init(id);
		model.addAttribute("contentResult", contentResult);
		return "test-db";
	}

}
