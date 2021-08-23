package org.ssglobal.training.codes;

import java.util.ArrayDeque;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QueueCandies {
	
	private static Logger logger = LogManager.getLogger("queueCandiesLogger");
	
	/**
	 * Returns Queue representing eating order on specified day
	 * 
	 * @param Queue dispenser
	 * @param int day
	 * @return Queue
	 */
	
	public Queue<String> getCandy(Queue<String> dispenser, int day) {
		logger.info("execute getCandy dispenser = {} day = {}", 
					dispenser.toString(), String.valueOf(day));
		
		logger.info("validating if day is valid");
		if (day > 6 || day < 0) {
			System.err.println("day is invalid");
			logger.info("day is invalid, exit getCandy return null");
			return null;
		}
		
		Queue<String> eatingOrder = new ArrayDeque<>();
		
		logger.info("day is valid, going through dispenser");
		while (dispenser.isEmpty() == false) {
			
			logger.info("removing candy from dispenser, adding to eatingOrder");
			eatingOrder.add(dispenser.poll());
			
			logger.info("checking if dispenser is empty");
			if (dispenser.peek() == null) {
				logger.info("dispenser empty");
				break;
			}
			
			logger.info("dispenser not empty");
			for (int i = 0; i < day; i++) {
				logger.info("removing candy from dispenser");
				String toReturn = dispenser.poll();
				
				logger.info("returning candy to dispenser");
				dispenser.add(toReturn);
			}
		}
		logger.info(" exit getCandy return eatingOrder = {}", eatingOrder.toString());
		return eatingOrder;	
	}
}
