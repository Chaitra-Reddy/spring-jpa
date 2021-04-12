package com.practice.mvc.exception;

import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandler 
{
	@ExceptionHandler(ApplicationException.class)
	public String handleExceptions(ApplicationException e, WebRequest request, Model m)
	{
		ErrorDetail errorDetail = new ErrorDetail(new Date(), e.getMessage(), request.getDescription(false));
		m.addAttribute("error", errorDetail);
		return "errors";
	}
}
