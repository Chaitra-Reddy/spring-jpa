package com.practice.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.mvc.entity.Activity;
import com.practice.mvc.exception.controller_exceptions.ControllerException;
import com.practice.mvc.exception.service_exceptions.ServiceException;
import com.practice.mvc.service.ActivityService;

@Controller
public class ActivityController 
{
	@Autowired
	private ActivityService aservice;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/add-activity")
	public String addActivity(Model m)
	{
		Activity activity =  new Activity();
		m.addAttribute("activity", activity);
		return "addActivity";
	}
	
	@RequestMapping("/after-add")
	public String afterAddingActivity(@ModelAttribute("activity") Activity activity) throws ControllerException
	{
		try
		{
			activity = aservice.addActivity(activity);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
		return "index";
	}
}
