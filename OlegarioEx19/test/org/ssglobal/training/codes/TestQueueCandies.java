package org.ssglobal.training.codes;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQueueCandies {
	
	private QueueCandies qc;
	
	@BeforeEach
	public void setUp() {
		qc = new QueueCandies();
	}
	
	@Test
	public void testGetCandy() {
		Queue<String> data = new ArrayDeque<>();
		data.add("Chocolate");
		data.add("Cola");
		data.add("Peppermint");
		data.add("BlueRaspberry");
		data.add("Grape");
		data.add("Green Apple");
		data.add("Lemon");
		data.add("Orange");
		data.add("Raspberry");
		data.add("Watermelon");
		
		Queue<String> expected = new ArrayDeque<>(data);
		Assertions.assertIterableEquals(expected, qc.getCandy(data, 0));
	}
	
	@AfterEach
	public void tearDown() {
		qc = null;
	}

}
