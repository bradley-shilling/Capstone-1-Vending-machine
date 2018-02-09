package com.techelevator;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	VendingMachine vm;

	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
	}

	@Test
	public void testFinalize() throws FileNotFoundException {
		vm.deposit(new BigDecimal ("1.00"));
		vm.finalize();
		assertEquals(new BigDecimal ("0.00"), vm.balance);
	}

	@Test
	public void testDeposit() throws FileNotFoundException {
		vm.deposit(new BigDecimal ("1.00"));
		assertEquals(new BigDecimal ("1.00"), vm.balance);
	}


	@Test
	public void testDispence() {
		vm.dispence("A1");
		assertEquals(4, vm.getInventory().get("A1").size());
	}


}
