package com.kata.tennis;

import java.util.Scanner;

import com.kata.tennis.exceptions.GameAlreadyEndedException;
import com.kata.tennis.exceptions.SetAlreadyEndedException;
import com.kata.tennis.model.Player;
import com.kata.tennis.model.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Player player1 = new Player();
		Player player2 = new Player();
		System.out.println("Please enter the player 1 name");
		player1.setName(scanner.nextLine());
		System.out.println("Please enter the player 2 name");
		player2.setName(scanner.nextLine());
		Set set = new Set(player1, player2);
		System.out.println("Game Started ");
		String choice = "0";
		while (true) {
			System.out.println("Here are your choices :");
			System.out.println("	1 - " + player1.getName() + " scores");
			System.out.println("	2 - " + player2.getName() + " scores");
			System.out.println("	3 - Display Game score");
			System.out.println("	4 - Display Set score");
			//System.out.println("	5 - New match");
			System.out.println("	0 - Quit");
			choice = scanner.nextLine();
			if ("0".equals(choice))
				break;
			try {
				switch (choice) {
				case "1":
					set.player1Scores();
					break;
				case "2":
					set.player2Scores();
					break;
				case "3":
					System.out.println(set.getCurrentGame().showScore());
					break;
				case "4":
					System.out.println(set.showScore());
					break;
				}
			} catch (GameAlreadyEndedException e) {
				System.out.println(e.getMessage());
			} catch (SetAlreadyEndedException e) {
				System.out.println(e.getMessage());
			}
			if (set.getWinner() != null)
				System.out.println(set.getWinner().getName() + " has won the match");
		}
		scanner.close();
	}

}
