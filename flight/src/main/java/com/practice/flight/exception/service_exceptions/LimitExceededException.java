package com.practice.flight.exception.service_exceptions;

public class LimitExceededException extends ServiceException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LimitExceededException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LimitExceededException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LimitExceededException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LimitExceededException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LimitExceededException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
