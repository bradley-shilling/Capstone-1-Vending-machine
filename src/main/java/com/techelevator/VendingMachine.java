package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class VendingMachine {
	// intstance variables
	BigDecimal balance = new BigDecimal("0.00"); // set up initial balance
	private Map inventory;
	List<Items> itemBin = new ArrayList<Items>();
	
	
	//constructor
	public VendingMachine() throws FileNotFoundException {
		inventoryReader x = new inventoryReader(); // make  new inventory reader
		this.inventory = x.generateInventory(); // make new machine && pass in inventory
		
	}
	
	
	
	// methods
	// deposit
	public void deposit(BigDecimal ammount) {
	balance.add(ammount);// add amount to current balance
	}
	// dispense
	public String dispence(String slot) {
		//remove from stack 
		
		
		
		//add to item bin
		
		//reduce balance
		
	
		
		return null;
	}
	
	// finish
	public void finish() {
	
		
		return;
	}



	public Map getInventory() {
		return inventory;
	}

	

}
