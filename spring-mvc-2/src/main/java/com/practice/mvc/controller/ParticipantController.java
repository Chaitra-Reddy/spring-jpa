package com.practice.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.mvc.entity.Activity;
import com.practice.mvc.entity.Participant;
import com.practice.mvc.exception.controller_exceptions.ControllerException;
import com.practice.mvc.exception.service_exceptions.ServiceException;
import com.practice.mvc.service.ActivityService;
import com.practice.mvc.service.ParticipantService;

@Controller
public class ParticipantController 
{
	@Autowired 
	private ActivityService aservice;
	
	@Autowired 
	private ParticipantService pservice;
	
	@RequestMapping("/add-participant")
	public String addParticipant(Model m) throws ControllerException
	{
		try
		{
			Participant participant = new Participant();
			m.addAttribute("participant", participant);
			List<Activity> activities = aservice.getAllActivities();
			m.addAttribute("activities",activities);
			return "addParticipant";
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("after-add-part")
	public String afterAddParticipant(@ModelAttribute("participant") Participant participant, Model m) throws ControllerException
	{
//		m.addAttribute(", m)
		try
		{
			participant = pservice.addParticipant(participant);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
		return "index";
	}
}
