package com.tirmizee.backend.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.backend.dao.PermissionDao;
import com.tirmizee.backend.dao.RoleDao;
import com.tirmizee.core.commons.CustomMapper;

@Controller
public class RootWebController {

	private static final Logger LOGGER =  Logger.getLogger(RootWebController.class);
	
	@Autowired @Lazy
 	CustomMapper mapper;

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	RoleDao roleDao; 
	
	@Autowired
	PermissionDao permissionDao;
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView,@RequestParam(value = "error", required = false) String error) {
		LOGGER.debug("start web");
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView("index");
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		return model;
	}
	
}
