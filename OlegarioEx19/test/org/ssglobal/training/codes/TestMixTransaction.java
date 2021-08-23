package org.ssglobal.training.codes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMixTransaction {
	
	@Test
	public void testFileExists() {
		Assertions.assertFalse(MixTransaction.fileExists(""));
	}
	
	@Test
	public void isInt() {
		Assertions.assertFalse(MixTransaction.isInt("A"));
	}
	
	@Test
	public void isDouble() {
		Assertions.assertFalse(MixTransaction.isDouble("A"));
	}
	
	@Test
	public void convertMatrix() {
		try {
			MixTransaction.convertMatrix("");
		} catch (Exception e) {
		}
	}
	

}
