package com.practice.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.mvc.entity.Activity;
import com.practice.mvc.exception.service_exceptions.DuplicateException;
import com.practice.mvc.exception.service_exceptions.NotFoundException;
import com.practice.mvc.exception.service_exceptions.ServiceException;
import com.practice.mvc.repository.ActivityRepository;
import com.practice.mvc.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService
{
	@Autowired
	private ActivityRepository arepo;

	@Override
	public Activity addActivity(Activity activity) throws ServiceException 
	{
		Activity tempActivity = null;
		try
		{
			tempActivity = arepo.findByName(activity.getName());
			if(tempActivity == null)
			{
				return arepo.save(activity);
			}
			else
			{
				throw new DuplicateException("Duplicate activity name. Try again.");
			}
			
		}
		catch(DuplicateException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Activity> getAllActivities() throws ServiceException 
	{	
		List<Activity> activities = new ArrayList<>();
		try
		{
			activities = arepo.findAll();
			if(activities.isEmpty())
			{
				throw new NotFoundException("No activities found. Please add some activities first.");
			}
			else
			{
				return activities;
			}
		}
		catch(NotFoundException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}
	
}
