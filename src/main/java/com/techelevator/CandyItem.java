package com.techelevator;

import java.math.BigDecimal;

public class CandyItem extends Items {

	public String getMessage() {
		return  "Munch Munch, Yum!";
	}
	
	// constructor
		public CandyItem (String name, BigDecimal price) {
			this.name = name;
			this.price = price;
		}
	

}
