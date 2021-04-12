package com.practice.shop.exception.item;

import com.practice.shop.exception.ServiceException;

public class ItemServiceException extends ServiceException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ItemServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ItemServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ItemServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
