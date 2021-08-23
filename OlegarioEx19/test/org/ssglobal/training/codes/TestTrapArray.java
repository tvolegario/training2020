package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTrapArray {
	
	private TrapArray ta;
	
	@BeforeEach
	public void setUp() {
		ta = new TrapArray();
	}
	
	@Test
	public void testArrayTransact() {
		ta.arrayTransact();
	}
	
	@AfterEach
	public void tearDown() {
		ta = null;
	}

}
