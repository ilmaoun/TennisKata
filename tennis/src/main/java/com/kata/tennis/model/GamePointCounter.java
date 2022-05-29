package com.kata.tennis.model;

public class GamePointCounter {
	
	private String value;
	private GamePointCounter previous;
	private GamePointCounter next;
	private boolean isInitialNode;
	
	private GamePointCounter() {}
	
	public static GamePointCounter initNewCounter() {
		GamePointCounter zero = new GamePointCounter();
		GamePointCounter fifteen = new GamePointCounter();
		GamePointCounter thirty = new GamePointCounter();
		GamePointCounter fourty = new GamePointCounter();
		// Setting the next score order
		zero.next =fifteen;
		fifteen.next = thirty;
		thirty.next = fourty;
		fourty.next = zero;
		// Setting the previous score order
		zero.previous = fourty;
		fifteen.previous = zero;
		thirty.previous = fifteen;
		fourty.previous = thirty;
		
		zero.value = "0";
		zero.isInitialNode=true;
		fifteen.value = "15";
		thirty.value = "30";
		fourty.value = "40";
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

}
