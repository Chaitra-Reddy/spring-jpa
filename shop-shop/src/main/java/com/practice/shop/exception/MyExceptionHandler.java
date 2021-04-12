package com.practice.shop.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandler 
{
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<?> resourceNotFound(ApplicationException exception, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setTimestamp(new Date());
		errorDetails.setMsg(exception.getMessage());
		errorDetails.setDetails(request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
