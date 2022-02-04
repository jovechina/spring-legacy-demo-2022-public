package com.jove.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jove.demo.models.ContentResult;
import com.jove.demo.models.User;
import com.jove.demo.services.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Validated User user, Model model) {
		logger.debug("userName: " +user.getUserName());
		logger.debug("password: " +user.getPassword());
		model.addAttribute("userName", user.getUserName());
		return "estimation-step-1";
	}
	
	@Autowired
    HomeService homeService;
	
	@RequestMapping(value = "/test-db/{id}", method = RequestMethod.GET)
	public String content(@PathVariable int id, Model model) {
		ContentResult contentResult = homeService.init(id);
		model.addAttribute("contentResult", contentResult );
        return "test-db";
	}
	
}
