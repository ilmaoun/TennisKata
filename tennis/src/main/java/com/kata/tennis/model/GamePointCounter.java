package com.kata.tennis.model;

public class GamePointCounter {
	
	private String value;
	private GamePointCounter previous;
	private GamePointCounter next;
	private boolean isInitialNode;
	private boolean isDeuceNode;
	private boolean isAdvNode;
	
	private GamePointCounter() {}
	
	public static GamePointCounter initNewCounter() {
		GamePointCounter zero = new GamePointCounter();
		GamePointCounter fifteen = new GamePointCounter();
		GamePointCounter thirty = new GamePointCounter();
		GamePointCounter fourty = new GamePointCounter();
		GamePointCounter deuce = new GamePointCounter();
		GamePointCounter adv = new GamePointCounter();
		// Setting the next score order
		zero.next =fifteen;
		fifteen.next = thirty;
		thirty.next = fourty;
		fourty.next = deuce;
		deuce.next = adv;
		adv.next = zero;
		// Setting the previous score order
		zero.previous = adv;
		fifteen.previous = zero;
		thirty.previous = fifteen;
		fourty.previous = thirty;
		deuce.previous = fourty;
		adv.previous = deuce;
		zero.value = "0";
		
		zero.isInitialNode=true;
		fifteen.value = "15";
		thirty.value = "30";
		fourty.value = "40";
		deuce.value = "DEUCE";
		deuce.isDeuceNode = true;
		adv.value = "ADV";
		adv.isAdvNode = true;
		return zero;
	}
	
	public GamePointCounter getNext() {
		return next;
	}

	public GamePointCounter getPrevious() {
		return previous;
	}

	public String getValue() {
		return value;
	}

	public boolean isInitialNode() {
		return isInitialNode;
	}

	public boolean isDeuceNode() {
		return isDeuceNode;
	}

	public boolean isAdvNode() {
		return isAdvNode;
	}

}
