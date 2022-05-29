package com.kata.tennis;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kata.tennis.model.GamePointCounter;

public class GamePointTest {

	@Test
	public void testCyclicCounter() {
		GamePointCounter counter = GamePointCounter.initNewCounter();
		assertEquals("0", counter.getValue());
		assertEquals(true, counter.isInitialNode());
		
		counter = counter.getNext();
		assertEquals("15", counter.getValue());
		assertEquals(false, counter.isInitialNode());
		
		counter = counter.getNext();
		assertEquals("30", counter.getValue());
		assertEquals(false, counter.isInitialNode());
		
		counter = counter.getNext();
		assertEquals("40", counter.getValue());
		assertEquals(false, counter.isInitialNode());
		
		counter = counter.getNext();
		assertEquals("0", counter.getValue());
		assertEquals(true, counter.isInitialNode());
		
		counter = counter.getPrevious();
		assertEquals("40", counter.getValue());
		assertEquals(false, counter.isInitialNode());
		
		
	}

}
