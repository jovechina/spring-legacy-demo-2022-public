package com.jove.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jove.demo.models.CodeMaster;
import com.jove.demo.models.Estimation;
import com.jove.demo.models.RoomCategory;
import com.jove.demo.models.RoomType;
import com.jove.demo.models.User;
import com.jove.demo.services.CodeMasterService;
import com.jove.demo.services.RoomCategoryService;
import com.jove.demo.services.RoomTypeService;

@Controller
@SessionAttributes({ "user", "estimation" })
public class EstimationController {

	private static final Logger logger = LoggerFactory.getLogger(EstimationController.class);

	@Autowired
	CodeMasterService codeMasterService;

	@Autowired
	RoomCategoryService roomCategoryService;

	@Autowired
    RoomTypeService roomTypeService;
	
	@Autowired
	private HomeController homeController;
	
	@RequestMapping(value = "/estimation-1", method = RequestMethod.POST)
	public String estimationStepOne(@RequestParam String action, @Validated Estimation reqEstimation,BindingResult result, Model model) {
		logger.debug("estimation 1 controller -> estimation step 2 page init");
		if (action.equals("prev")) {
			return homeController.home(model);
		} else {
			return estimationStepTwoInit(reqEstimation,model);
		}
	}

	@RequestMapping(value = "/estimation-2", method = RequestMethod.POST)
	public String estimationStepTwo(@RequestParam String action, @RequestParam String pageStatus, @Validated Estimation reqEstimation, Model model) {
		
		if (pageStatus.equals("false")) {
			// input page
			logger.debug("estimation 2 controller - input page");	
			if (action.equals("prev")) {
				return estimationStepOneInit(model);
			} else {
				return estimationStepThreeInit(reqEstimation, model);
			}			
		} else {
			// confirm page
			logger.debug("estimation 2 controller - confirm page");
			if (action.equals("prev")) {
				return estimationStepTwoInit(reqEstimation,model);
			} else {
				//return estimationSuccess(reqEstimation, model);
				return estimationStepThreeInit(reqEstimation, model);
			}			
		}
	}

//	@RequestMapping(value = "/estimation-3", method = RequestMethod.POST)
//	public String estimationStepThree(@RequestParam String action, @RequestParam String pageStatus,  @Validated Estimation reqEstimation, Model model) {
//		logger.debug("estimation 3 controller -> estimation step 4 page init");
//
//		if (action.equals("prev")) {
//			return estimationStepTwoInit(reqEstimation,model);
//		}
//
////		// 装修服务
////		List<RoomCategory> roomCategories = roomCategoryService.selectAll();
////		model.addAttribute("roomCategories",roomCategories);
////		model.addAttribute("estimation",reqEstimation);
//		return "estimation-step-3";
//	}
	
	protected String estimationStepOneInit(Model model) {
		// 准备下个画面(estimation-step-1)的初始数据
		// 画面项目显示数据，默认选择可以在这里设置
		Estimation estimation = (Estimation) model.getAttribute("estimation");
		if (estimation == null ) {
			logger.debug("estimation is null");
			User user = (User) model.getAttribute("user");
			if (user == null || user.getUserName() == null || user.getUserName().equals("")) {
				logger.error("session过期，请重新登录。");
			}
			estimation = new Estimation();
			estimation.setUserId(user.getUserId());
		}
		// 户型
		List<RoomType> roomTypes = roomTypeService.getAll();
		// 装修状况的Category 1
		List<CodeMaster> codeMasters = codeMasterService.getByCategory(1);
		
		model.addAttribute("roomTypes", roomTypes);
		model.addAttribute("codeMasters", codeMasters);
		model.addAttribute("estimation", estimation);
		return "estimation-step-1";
	}
	

	private String estimationStepTwoInit (@Validated Estimation reqEstimation, Model model) {
		logger.debug("estimation step 2 page init");

		Estimation estimation = (Estimation) model.getAttribute("estimation");
		if (estimation == null) {
			logger.error("estimation is null");
		}
		estimation.setRoomId(reqEstimation.getRoomId());
		estimation.setInteriorDecoration(reqEstimation.getInteriorDecoration());

		logger.debug("roomType:" + estimation.getRoomId());
		logger.debug("interiorDecoration:" + estimation.getInteriorDecoration());
		estimation.setCable("5");
		estimation.setCeiling("3");

		// 装修服务
		List<RoomCategory> roomCategories = roomCategoryService.selectAll();

		model.addAttribute("roomCategories", roomCategories);
		model.addAttribute("estimation", estimation);
		model.addAttribute("pageStatus", "false");

		return "estimation-step-2";
	}		
	
	private String estimationStepThreeInit(@Validated Estimation reqEstimation, Model model) {
		logger.debug("estimation step 3 page init");
		// 装修服务
		List<RoomCategory> roomCategories = roomCategoryService.selectAll();
		model.addAttribute("roomCategories", roomCategories);
		model.addAttribute("estimation", reqEstimation);
		model.addAttribute("pageStatus", "true");
		return "estimation-step-2";
	}	
}
