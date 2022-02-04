package com.jove.demo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jove.demo.models.CodeMaster;
import com.jove.demo.models.Estimation;
import com.jove.demo.models.RoomCategory;
import com.jove.demo.models.RoomType;
import com.jove.demo.models.User;
import com.jove.demo.services.CodeMasterService;
import com.jove.demo.services.EstimationService;
import com.jove.demo.services.RoomCategoryService;
import com.jove.demo.services.RoomTypeService;

@Controller
@SessionAttributes({ "user", "estimation", "pageType" })
public class EstimationController {

	private static final String PAGE_MODEL_NEW = "NEW";
	private static final String PAGE_MODEL_EDIT = "EDIT";
	private static final String PAGE_MODEL_DETAIL = "DETAIL";

	private static final Logger logger = LoggerFactory.getLogger(EstimationController.class);

	@Autowired
	CodeMasterService codeMasterService;

	@Autowired
	RoomCategoryService roomCategoryService;

	@Autowired
	RoomTypeService roomTypeService;

	@Autowired
	private HomeController homeController;

	@Autowired
	private EstimationService estService;

	@RequestMapping(value = "/estimation-1", method = RequestMethod.POST)
	public String estimationStepOne(@RequestParam String action, @Validated Estimation reqEstimation,
			BindingResult result, Model model) {
		logger.debug("estimation 1 controller -> estimation step 2 page init");
		if (action.equals("prev")) {
			return homeController.home(model);
		} else {
			String pageType = (String) model.getAttribute("pageType");
			if (pageType == null || pageType.equals("")) {
				pageType = PAGE_MODEL_NEW;
			}
			model.addAttribute("pageType", pageType);
			return estimationStepTwoInit(reqEstimation, model);
		}
	}

	@RequestMapping(value = "/estimation-2", method = RequestMethod.POST)
	public String estimationStepTwo(@RequestParam String action, @RequestParam String pageStatus,
			@Validated Estimation reqEstimation, Model model) {

		String pageType =  (String) model.getAttribute("pageType");
		
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
			int estimationId = 0;
			if (action.equals("prev")) {
				return estimationStepTwoInit(reqEstimation, model);
			} else {
				if (pageType.equals(PAGE_MODEL_EDIT)) {
					estimationId = reqEstimation.getEstimationId();
					estService.update(reqEstimation);
				} else if (pageType.equals(PAGE_MODEL_NEW)) {
					estimationId = estService.insert(reqEstimation);
				} else {
					logger.error("系统异常，错误代码0x000001,请与系统管理员联系。");
				}
			}

			User user = (User) model.getAttribute("user");
			if (user == null || user.getUserName() == null || user.getUserName().equals("")) {
				logger.error("session过期，请重新登录。");
			}

			Estimation estimation = new Estimation();
			estimation = new Estimation();
			estimation.setUserId(user.getUserId());
			model.addAttribute("estimation", estimation);
			return estimationSuccess(estimationId, model);
		}
	}

	@RequestMapping(value = "/estimation-search", method = RequestMethod.GET)
	public String estimationLists(Model model) {
		logger.debug("estimation list page init");
		List<Estimation> estLists = estService.selectToSearchResult();
		model.addAttribute("estLists", estLists);
		return "estimation-list";
	}

	@RequestMapping(value = "/estimation/detail/{id}", method = RequestMethod.GET)
	public String estimationDetail(@PathVariable int id, Model model) {
		Estimation estimation = estService.selectOne(id);
		model.addAttribute("pageType", PAGE_MODEL_DETAIL);
		model.addAttribute("estimation", estimation);
		return estimationStepThreeInit(estimation, model);
	}

	@RequestMapping(value = "/estimation/edit/{id}", method = RequestMethod.GET)
	public String estimationEdit(@PathVariable int id, Model model) {
		Estimation estimation = estService.selectOne(id);
		model.addAttribute("pageType", PAGE_MODEL_EDIT);	
		model.addAttribute("estimation", estimation);
		return estimationStepTwoInit(estimation, model);
	}
	
	@RequestMapping(value = "/estimation/del/{id}", method = RequestMethod.GET)
	public String estimationDel(@PathVariable int id, Model model) {
		estService.del(id);
		return estimationLists(model);
	}	

	// 共同方法

	protected String estimationStepOneInit(Model model) {
		// 准备下个画面(estimation-step-1)的初始数据
		// 画面项目显示数据，默认选择可以在这里设置
		Estimation estimation = (Estimation) model.getAttribute("estimation");
		if (estimation == null) {
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

	private String estimationStepTwoInit(@Validated Estimation reqEstimation, Model model) {
		logger.debug("estimation step 2 page init");
		Estimation estimation = (Estimation) model.getAttribute("estimation");
		if (estimation == null) {
			logger.error("estimation is null");
		}
		estimation.setRoomId(reqEstimation.getRoomId());
		estimation.setInteriorDecoration(reqEstimation.getInteriorDecoration());

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

	private String estimationSuccess(int estimationId, Model model) {
		logger.debug("estimation successpage init");
//		String pageType = (String) model.getAttribute("pageType");		
		model.addAttribute("estimationId", estimationId);
//		model.addAttribute("pageType", pageType);
		return "estimation-success";
	}
}
