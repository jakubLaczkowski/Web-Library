package com.jakublaczkowski.weblibrary.exception;

public class BookAlreadyLentException extends Throwable {

	private static final long serialVersionUID = 1L;

	public BookAlreadyLentException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
