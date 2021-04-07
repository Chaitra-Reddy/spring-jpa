package com.mindtree.Login.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.Login.dto.UserDto;
import com.mindtree.Login.entity.User;

@Component
public class UserConverter {
	
	public UserDto entityToDto(User user) {
		
		ModelMapper mapper=new ModelMapper();
		UserDto dto=mapper.map(user, UserDto.class);
		
		return dto;
	}
}
