package com.practice.mvc.service;

import java.util.List;

import com.practice.mvc.entity.Activity;
import com.practice.mvc.exception.service_exceptions.ServiceException;

public interface ActivityService 
{
	public Activity addActivity(Activity activity) throws ServiceException;
	public List<Activity> getAllActivities() throws ServiceException;
}
