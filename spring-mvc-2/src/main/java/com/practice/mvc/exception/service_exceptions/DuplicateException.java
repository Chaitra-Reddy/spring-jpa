package com.practice.mvc.exception.service_exceptions;

public class DuplicateException extends ServiceException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
