package com.jakublaczkowski.weblibrary.exception;

public class BookDoesNotExistException extends Throwable {

	private static final long serialVersionUID = 1L;

	public BookDoesNotExistException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
