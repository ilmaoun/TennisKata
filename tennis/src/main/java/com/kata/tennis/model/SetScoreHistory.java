package com.kata.tennis.model;

public class SetScoreHistory {
	private Game game;
	private Integer initialPlayer1SetScore;
	private Integer initialPlayer2SetScore;
	private Integer finalPlayer1SetScore;
	private Integer finalPlayer2SetScore;
	
	public SetScoreHistory(Game game,Integer  initialPlayer1SetScore, Integer initialPlayer2SetScore){
		this.game = game;
		this.initialPlayer1SetScore = initialPlayer1SetScore;
		this.initialPlayer2SetScore = initialPlayer2SetScore;
	}

	public Game getGame() {
		return game;
	}

	public Integer getInitialPlayer1SetScore() {
		return initialPlayer1SetScore;
	}

	public Integer getInitialPlayer2SetScore() {
		return initialPlayer2SetScore;
	}

	public Integer getFinalPlayer1SetScore() {
		return finalPlayer1SetScore;
	}

	public Integer getFinalPlayer2SetScore() {
		return finalPlayer2SetScore;
	}
	
	public void setFinalScore(Integer finalPlayer1Score,Integer finalPlayer2Score) {
		this.finalPlayer1SetScore = finalPlayer1Score;
		this.finalPlayer2SetScore = finalPlayer2Score;
	}

	
	
	
	
}