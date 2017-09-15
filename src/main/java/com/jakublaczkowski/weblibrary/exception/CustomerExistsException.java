package com.jakublaczkowski.weblibrary.exception;

public class CustomerExistsException extends Throwable {

	private static final long serialVersionUID = -8414044857441083624L;

	public CustomerExistsException(String exceptionMessage) {
		super(exceptionMessage);
	};
	
}
