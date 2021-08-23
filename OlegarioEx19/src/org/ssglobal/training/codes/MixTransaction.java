package org.ssglobal.training.codes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StreamTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MixTransaction {
	
	private static Logger logger = LogManager.getLogger("mixTransactionLogger");
	
	public static boolean fileExists(String filename) {
		logger.info("execute fileExists");
		File file = new File(filename);
		logger.info("exit fileExists");
		return file.exists();
	}
	
	public static boolean isInt(String strVal) {
		logger.info("execute isInt");
		try {
			Integer.parseInt(strVal);
			logger.info("exit isInt return true");
			return true;
		} catch (NumberFormatException e) {
			logger.error("{} has been encountered", e.getClass().getName());
			logger.info("exit isInt return false");
			return false;
		}
	}
	
	public static boolean isDouble(String strVal) {
		logger.info("execute isDouble");
		try {
			Double.parseDouble(strVal);
			logger.info("exit isDouble return true");
			return true;
		} catch (NumberFormatException e) {
			logger.error("{} has been encountered", e.getClass().getName());
			logger.info("exit isDouble return false");
			return false;
		}
	}
	
	public static int[][] convertMatrix(String filename) throws 
				WrongMatrixValuesException, WrongMatrixDimensionsException, 
				FileNotFoundException, Exception{
		logger.info("execute convertMatrix filename = {}", filename);
		logger.info("validating if file exists");
		if (fileExists(filename) == false) {
			logger.error("FileNotFoundException has been encountered");
			throw new FileNotFoundException();
		}
		
		logger.info("file exists");
		File file = new File(filename);
		FileReader fr = new FileReader(file);
		StreamTokenizer st = new StreamTokenizer(fr);
			
		int[] matrixValues = new int[9];
		byte counter = 0;
		int token = st.nextToken();
		
		while (token != StreamTokenizer.TT_EOF) {
			if (counter == 9) break;
			if (token != StreamTokenizer.TT_NUMBER) {
				logger.error("WrongMatrixValuesException has been encountered");
				throw new WrongMatrixValuesException();
			}
			matrixValues[counter] = (int) st.nval;
			token = st.nextToken();
			counter++;
		}
		
		fr.close();
		if (counter < 9) {
			logger.error("WrongMatrixDimensionsException has been encountered");
			throw new WrongMatrixDimensionsException();
		}
		
		int[][] matrix = new int[3][3];
		counter = 0;
		
		for (int[] row: matrix) {
			for (int i = 0; i < row.length; i++) {
				row[i] = matrixValues[counter];
				counter++;
			}
		}
		logger.info("exit convertMatrix with no errors");
		return matrix;	
	}
}
