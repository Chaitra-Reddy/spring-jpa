package com.practice.mvc.service;

import com.practice.mvc.entity.Participant;
import com.practice.mvc.exception.service_exceptions.ServiceException;

public interface ParticipantService 
{
	public Participant addParticipant(Participant participant) throws ServiceException;
}
