package com.techelevator;

import java.math.BigDecimal;

public class ChipsItem extends Items {
	

	public String getMessage() {
		return "Crunch Crunch, Yum!";
	}
	
	// constructor
		public ChipsItem (String name, BigDecimal price) {
			this.name = name;
			this.price = price;
		}
	

}
