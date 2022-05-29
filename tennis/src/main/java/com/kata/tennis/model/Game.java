package com.kata.tennis.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kata.tennis.exceptions.GameAlreadyEndedException;

public class Game {

	private Player player1;
	private Player player2;
	private GamePointCounter player1Counter;
	private GamePointCounter player2Counter;
	private List<GameScoreHistory> scoreHistory = new ArrayList<>();
	private Player winner;

	public Game(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.player1Counter = GamePointCounter.initNewCounter();
		this.player2Counter = GamePointCounter.initNewCounter();
		scoreHistory.add(new GameScoreHistory(player1Counter.getValue(),player2Counter.getValue()));
	}

	public void player1Scores() throws GameAlreadyEndedException {
		if (winner != null)
			throw new GameAlreadyEndedException("The player " + winner.getName() + " have already won the game");
		if (player1Counter.getNext().isInitialNode()) {// The score is reset
			winner = player1;
			return;
		}
		player1Counter = player1Counter.getNext();
		if(player1Counter.isAdvNode())
			player2Counter = player2Counter.getPrevious();
		if(player1Counter.isDeuceNode())
			if(player2Counter.isAdvNode())
				player2Counter = player2Counter.getPrevious();
			else
				player1Counter = player1Counter.getNext();
		GameScoreHistory newScoreEntry = new GameScoreHistory(player1Counter.getValue(),player2Counter.getValue());
		scoreHistory.add(newScoreEntry);
	}

	public void player2Scores() throws GameAlreadyEndedException {
		if (winner != null)
			throw new GameAlreadyEndedException("The player " + winner.getName() + " have already won the game");
		if (player2Counter.getNext().isInitialNode()) {// The score is reset
			winner = player2;
			return;
		}
		player2Counter = player2Counter.getNext();
		if(player2Counter.isAdvNode())
			player1Counter = player1Counter.getPrevious();
		if(player2Counter.isDeuceNode())
			if(player1Counter.isAdvNode())
				player1Counter = player1Counter.getPrevious();
			else
				player2Counter = player2Counter.getNext();
		GameScoreHistory newScoreEntry = new GameScoreHistory(player1Counter.getValue(),player2Counter.getValue());
		scoreHistory.add(newScoreEntry);
	}

	public Player getWinner() {
		return winner;
	}
	
	

	public List<GameScoreHistory> getScoreHistory() {
		return scoreHistory;
	}

	public String showScore() {
		// TODO Auto-generated method stub
		String player1Score = StringUtils.rightPad(player1.getName(), 15);
		String player2Score = StringUtils.rightPad(player2.getName(), 15);
		String finalWinner = "";
		for(GameScoreHistory e :scoreHistory){
			player1Score = player1Score+StringUtils.center(e.getPlayer1Score(), 10);
			player2Score = player2Score+StringUtils.center(e.getPlayer2Score(), 10);
		}
		finalWinner = StringUtils.leftPad(finalWinner, player1Score.length());
		if(winner!=null) {
			player1Score = player1Score+StringUtils.center("0", 20);
			player2Score = player2Score+StringUtils.center("0", 20);
			finalWinner = finalWinner+StringUtils.center(winner.getName()+" wins the game", 20);
		}
		
		return player1Score +"\n"+player2Score+"\n"+finalWinner;
	}
}
