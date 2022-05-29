package com.kata.tennis.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kata.tennis.exceptions.GameAlreadyEndedException;
import com.kata.tennis.exceptions.SetAlreadyEndedException;

public class Set {

	private Integer player1SetCount;
	private Integer player2SetCount;
	// private Integer player1TieBreakHistoryCount;
	// private Integer player2TieBreakHistoryCount;
	private Player player1;
	private Player player2;
	private Game currentGame;
	private List<SetScoreHistory> setScoreHistory;

	private Player winner;

	public Set(Player player1, Player player2) {
		super();
		this.player1SetCount = 0;
		this.player2SetCount = 0;
		this.player1 = player1;
		this.player2 = player2;
		currentGame = new Game(player1, player2);
		setScoreHistory = new ArrayList<>();
		setScoreHistory.add(new SetScoreHistory(currentGame, 0, 0));

	}

	public void player1Scores() throws GameAlreadyEndedException, SetAlreadyEndedException {
		if (winner != null)
			throw new SetAlreadyEndedException("The player " + winner.getName() + " have already won the set");
		currentGame.player1Scores();
		if (currentGame.getWinner() == player1) {
			player1SetCount++;
			setScoreHistory.get(setScoreHistory.size() - 1).setFinalScore(player1SetCount, player2SetCount);
		}
		if (player1SetCount >= 7 || (player1SetCount == 6 && player2SetCount <= 4))
			winner = player1;
		else
			updateGameStatus();
	}

	public void player2Scores() throws GameAlreadyEndedException, SetAlreadyEndedException {
		if (winner != null)
			throw new SetAlreadyEndedException("The player " + winner.getName() + " have already won the set");
		currentGame.player2Scores();
		if (currentGame.getWinner() == player2) {
			player2SetCount++;
			setScoreHistory.get(setScoreHistory.size() - 1).setFinalScore(player1SetCount, player2SetCount);
		}
		if (player2SetCount >= 7 || (player2SetCount == 6 && player1SetCount <= 4))
			winner = player2;
		else
			updateGameStatus();
	}

	private void updateGameStatus() {
		if (currentGame.getWinner() != null) {
			currentGame = new Game(player1, player2);
			setScoreHistory.add(new SetScoreHistory(currentGame, player1SetCount, player2SetCount));
		}
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public Player getWinner() {
		return winner;
	}

	public String showScore() {
		// TODO Auto-generated method stub
		// String header1 = StringUtils.rightPad("", 15);
		String header2 = StringUtils.rightPad("", 15);
		String player1Score = StringUtils.rightPad(player1.getName(), 15);
		String player2Score = StringUtils.rightPad(player2.getName(), 15);
		String finalWinner = "";
		for (SetScoreHistory s : setScoreHistory) {
			/*
			 * if (header1.trim().equals("")) header1 = header1 +
			 * StringUtils.center("Start G/S", 20);
			 */
			for (int i = 0; i < s.getGame().getScoreHistory().size(); i++) {
				header2 = header2 + StringUtils.center("G. Score", 10) + StringUtils.center("S. Score", 10);
				player1Score = player1Score
						+ StringUtils.center(s.getGame().getScoreHistory().get(i).getPlayer1Score(), 10)
						+ StringUtils.center(String.valueOf(s.getInitialPlayer1SetScore()), 10);
				player2Score = player2Score
						+ StringUtils.center(s.getGame().getScoreHistory().get(i).getPlayer2Score(), 10)
						+ StringUtils.center(String.valueOf(s.getInitialPlayer2SetScore()), 10);
				if (i == s.getGame().getScoreHistory().size() - 1 && s.getGame().getWinner() != null) {
					header2 = header2 + "|";
					player1Score = player1Score + "|";
					player2Score = player2Score + "|";
				}
			}
		}

		finalWinner = StringUtils.leftPad(finalWinner, player1Score.length());
		if (winner != null) {
			header2 = header2 + StringUtils.center("G. Score", 10) + StringUtils.center("S. Score", 10);
			player1Score = player1Score + StringUtils.center("0", 10) + StringUtils.center(
					String.valueOf(setScoreHistory.get(setScoreHistory.size() - 1).getFinalPlayer1SetScore()), 10);
			player2Score = player2Score + StringUtils.center("0", 10) + StringUtils.center(
					String.valueOf(setScoreHistory.get(setScoreHistory.size() - 1).getFinalPlayer2SetScore()), 10);
			finalWinner = finalWinner + StringUtils.center(winner.getName() + " wins the set", 20);
		}

		return header2 + "\n" + player1Score + "\n" + player2Score + "\n" + finalWinner;
	}

}
