package com.jakublaczkowski.weblibrary.exception;

public class CustomerDoesNotExistException extends Throwable {

	private static final long serialVersionUID = 1L;

	public CustomerDoesNotExistException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
