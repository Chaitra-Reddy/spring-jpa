package com.practice.shop.exception.customer;

import com.practice.shop.exception.ServiceException;

public class CustomerServiceException extends ServiceException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
