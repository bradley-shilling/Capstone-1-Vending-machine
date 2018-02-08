package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ChangeTest {
	private BigDecimal balance;
	@Before
	public void setUp() throws Exception {
		balance = new BigDecimal("0.40");
		String change ="Your change is $5.55, that is 22 quarters 0 dimes 1 nickels.";
		

	}

	@Test
	public void testMakeChange() {
		Change changer = new Change();
		assertEquals("Your change is $0.40, that is 1 quarters 1 dimes 1 nickels.", changer.makeChange(balance));
		
	}

}
