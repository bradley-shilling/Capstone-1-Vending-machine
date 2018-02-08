package com.techelevator;

import java.math.BigDecimal;

public class Change {

	int quarter;
	BigDecimal washington = new BigDecimal("0.25");
	int dime;
	BigDecimal roosevelt = new BigDecimal("0.10");
	int nickel;
	BigDecimal jefferson = new BigDecimal("0.05");
	
	
	public String makeChange (BigDecimal balance) {
		BigDecimal total = balance;
	while (balance.compareTo(washington) >= 0) {
		quarter++;
		balance = balance.subtract(washington);
	} while(balance.compareTo(roosevelt) >= 0) {
		dime++;
		balance = balance.subtract(roosevelt);
	} while(balance.compareTo(jefferson) >= 0) {
		nickel++;
		balance = balance.subtract(jefferson);
	}
	return "Your change is $" + total +", that is "+ quarter + " quarters " + dime + " dimes " + nickel + " nickels.";

}

}
