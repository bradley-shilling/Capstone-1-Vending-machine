package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class GumItemTest {

	private GumItem gum;
	BigDecimal money = new BigDecimal("0.50");
	
	@Before
	public void setUp() throws Exception {
	gum = new GumItem("Wriggley", money);
	}

	@Test
	public void testGetMessage() {
		assertEquals("Chew Chew, Yum!", gum.getMessage());
	}

	@Test
	public void testGetName() {
		assertEquals("Wriggley", gum.getName());
	}

	@Test
	public void testGetPrice() {
		assertEquals(money, gum.getPrice());
	}

}
