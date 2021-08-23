package org.ssglobal.training.codes;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrapArray {
	
	private static Logger logger = LogManager.getLogger("trapLogger");
	
	public void arrayTransact() {
		logger.info("execute arrayTransact");
		Scanner scan = new Scanner(System.in);
		StringBuilder input;
		int size = 0;
		
		// Ask for array size until user enters a valid input
		while (true) {
			System.out.print("Enter the array size: ");
			input = new StringBuilder(scan.nextLine());
	
			try {
				size = Integer.parseInt(input.toString());
				if (size < 0) {
					logger.error(new InvalidSizeException().getMessage());
				}								 	
				else break;
			} catch(NumberFormatException e) {
				logger.error(new LetterSizeException().getMessage());
			}
			
		}
		
		// Initialize and fill array
		int[] values = new int[size];
		for(int i = 0; i < values.length; i++) {
			int value = 0;
			
			// Ask value until user enters a valid input
			while (true ) {
				System.out.print("Enter the value: ");
				input = new StringBuilder(scan.nextLine());
				
				try {
					value = Integer.parseInt(input.toString());
					break;
				} catch (NumberFormatException e) {
					try {
						Double.parseDouble(input.toString());
						System.out.println(new ElementDecimalException().
										       getMessage());
					} catch (NumberFormatException e1) {
						if (input.length() == 1) {
							logger.error("Error message: {}", e1.getMessage());
							System.out.println(new ElementCharException().
												   getMessage());
						}
						else {
							logger.error(new ElementStringException().getMessage());
						}
					}
				}
			}
			values[i] = value; 
		}
		
		// Ask for index until user enters E
		while(true) {
			int index = 0;
			System.out.print("Enter the index that you want to view:");
			input = new StringBuilder(scan.nextLine());
			
			// Check if user wants to exit
			if(input.toString().equalsIgnoreCase("E")) {
				System.err.println("Good Bye");
				break;
			}
			
			try {
				index = Integer.parseInt(input.toString());
			} catch(NumberFormatException e) {
				logger.error(new BadIndexException().getMessage());
			}
			
			try {
				System.out.printf("The value in index %d is %d \n", 
								   index, values[index]);
			} catch(IndexOutOfBoundsException e) {
				logger.error(new BadIndexException().getMessage());
			}
			
		}
		
		scan.close();
		logger.info("exit arrayTransact");
	}

}
