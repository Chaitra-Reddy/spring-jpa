package com.practice.flight.exception.service_exceptions;

public class DuplicateIDException extends ServiceException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateIDException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuplicateIDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DuplicateIDException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateIDException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateIDException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
