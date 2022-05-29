package com.kata.tennis.exceptions;

public class TennisKataException extends Exception{

	private static final long serialVersionUID = -6269856279260787675L;

	public TennisKataException() {
		super();
	}

	public TennisKataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TennisKataException(String message, Throwable cause) {
		super(message, cause);
	}

	public TennisKataException(String message) {
		super(message);
	}

	public TennisKataException(Throwable cause) {
		super(cause);
	}
	
	

}
