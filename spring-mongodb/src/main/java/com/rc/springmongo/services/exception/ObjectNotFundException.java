package com.rc.springmongo.services.exception;

public class ObjectNotFundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFundException(String msg) {
		super(msg);
	}

}
