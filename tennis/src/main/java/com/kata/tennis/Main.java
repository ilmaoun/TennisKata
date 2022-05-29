package com.kata.tennis;

import java.util.Scanner;

import com.kata.tennis.exceptions.GameAlreadyEndedException;
import com.kata.tennis.model.Game;
import com.kata.tennis.model.Player;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Player player1 = new Player();
		Player player2 = new Player();
		System.out.println("Please enter the player 1 name ");
		player1.setName(scanner.nextLine());
		System.out.println("Please enter the player 2 name ");
		player2.setName(scanner.nextLine());
		Game game = new Game(player1, player2);
		System.out.println("Game Started ");
		String choice = "0";
		while (true) {
			System.out.println("Here are your choices :");
			System.out.println("	1 - "+player1.getName()+" scores");
			System.out.println("	2 - "+player2.getName()+" scores");
			System.out.println("	3 - Display score");
			System.out.println("	0 - Quit");
			choice = scanner.nextLine();
			if ("0".equals(choice))
				break;
			try {
				switch (choice) {
				case "1":
					game.player1Scores();
					break;
				case "2":
					game.player2Scores();
					break;
				case "3":
					System.out.println(game.showScore());
				}
			} catch (GameAlreadyEndedException e) {
				System.out.println(e.getMessage());
			}
		}
		scanner.close();
	}

}
