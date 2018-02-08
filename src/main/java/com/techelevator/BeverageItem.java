package com.techelevator;

import java.math.BigDecimal;

public class BeverageItem extends Items {

	public String getMessage() {
		return "Glug Glug, Yum!";
	}
	
	// constructor
		public BeverageItem (String name, BigDecimal price) {
			this.name = name;
			this.price = price;
		}

	

}
