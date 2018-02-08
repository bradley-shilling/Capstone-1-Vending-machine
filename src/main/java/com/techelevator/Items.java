package com.techelevator;

import java.math.BigDecimal;

public abstract class Items {
	// inst var
	public String name;
	public BigDecimal price = new BigDecimal(0.00);
	
	//constructor
	
	
	// methods
	public abstract String getMessage();

	
	//getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

}
