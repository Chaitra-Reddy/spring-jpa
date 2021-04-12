package com.practice.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.mvc.entity.Participant;
import com.practice.mvc.exception.service_exceptions.NotValidException;
import com.practice.mvc.exception.service_exceptions.ServiceException;
import com.practice.mvc.repository.ParticipantRepository;
import com.practice.mvc.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService
{
	@Autowired
	private ParticipantRepository prepo;

	@Override
	public Participant addParticipant(Participant participant) throws ServiceException 
	{
		Participant p = null;
		try
		{
			if(participant.getAge() > 0 && participant.getAge() < 120)
			{
				p = prepo.save(participant);
				return p;
			}
			else
			{
				throw new NotValidException("Age has to be in the range of 0 to 120.");
			}
		}
		catch(NotValidException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}
	
}
