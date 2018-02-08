package com.techelevator;

import java.math.BigDecimal;

public class GumItem extends Items {

	public String getMessage() {
		return "Chew Chew, Yum!";
	}
	
	// constructor
	public GumItem (String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	

}
