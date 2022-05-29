package com.kata.tennis.exceptions;

public class GameAlreadyEndedException extends TennisKataException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6590240209105745758L;
	
	public GameAlreadyEndedException(String message) {
        super(message);
    }

}
