package com.kata.tennis.model;

public class GameScoreHistory {
	
	private String player1Score;
	private String player2Score;
	
	public GameScoreHistory(String player1Score, String player2Score) {
		super();
		this.player1Score = player1Score;
		this.player2Score = player2Score;
	}

	public String getPlayer1Score() {
		return player1Score;
	}
	public void setPlayer1Score(String player1Score) {
		this.player1Score = player1Score;
	}
	public String getPlayer2Score() {
		return player2Score;
	}
	public void setPlayer2Score(String player2Score) {
		this.player2Score = player2Score;
	}

}
