package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class VendingMachine {
	// intstance variables
	BigDecimal balance = new BigDecimal("0.00"); // set up initial balance
	private Map inventory;
	List<Items> itemBin = new ArrayList<Items>();

	// New scanner
	Scanner input = new Scanner(System.in);
	
	// new file writer method
	LogWriter log = new LogWriter();

	
	
	
	
	
	// constructor
	public VendingMachine() throws FileNotFoundException {
		inventoryReader x = new inventoryReader(); // make new inventory reader
		this.inventory = x.generateInventory(); // make new machine && pass in inventory

	}

	
	
	
	
	
	
	/*
	 * Methods
	 */

	// deposit
	public void deposit(BigDecimal ammount) throws FileNotFoundException {
		balance = balance.add(ammount);// add amount to current balance
		// log action
		String out = String.format("%-40s%-10s%-10s", "FEED MONEY:", "$"+ammount , "$" + balance); // format for log
		log.writeToFile(out);// log action
		System.out.println("The current balance is " + "$" + balance.toString());
	}

	
	
	
	
	
	
	
	// select product
	public void selectProduct() throws FileNotFoundException {
		// User Interactions
		System.out.print("Whaddya Buyin'?: ");
		String selectedProduct = input.nextLine();
		// logic
		if (this.getInventory().containsKey(selectedProduct) && this.getInventory().get(selectedProduct).size() >=1 && this.balance.compareTo(this.getInventory().get(selectedProduct).peek().getPrice()) >= 0) { // do if key is valid and balance is more than price																								
			System.out.println("Dispensing " + this.getInventory().get(selectedProduct).peek().getName() + ".");
			System.out.println();
			//log action
			String out = String.format("%-39s%-11s%-10s", this.getInventory().get(selectedProduct).peek().getName() + " @ " + selectedProduct , "-$" + this.getInventory().get(selectedProduct).peek().getPrice() , "$" + balance); // format for log
			log.writeToFile(out);// log action
			dispence(selectedProduct);
		} else if (this.getInventory().containsKey(selectedProduct) && this.getInventory().get(selectedProduct).size() >=1) {
			System.out.println("Not Enough Cash, Stranger.");
		} else if(this.getInventory().containsKey(selectedProduct)) {
			System.out.println("Sold Out.");
		} else {
			System.out.println("Invalid Selection");
		}

	}

	
	
	
	
	
	// dispense
	public String dispence(String slot) {
		// check if enough items are in stack
		if (this.getInventory().get(slot).size() < 1) {
			System.out.println("Item is Sold Out");
		} else {

			// remove from stack add to item bin
			itemBin.add(this.getInventory().get(slot).pop());
			// reduce balance
			balance = balance.subtract(returnPriceForKey(slot));
			System.out.println("$" + balance + " remaining balance.");

		}

		return null;
	}
	
	
	
	
	
	
	// Finalize method
	public void finalize() throws FileNotFoundException {
		// make change
	Change change = new Change();
	System.out.println();
	System.out.println(change.makeChange(this.balance));
	System.out.println();
	
	// set balance to 0
	BigDecimal startingBal = balance;
	balance = new BigDecimal("0.00");
	// log action
	String out = String.format("%-40s%-10s%-10s", "GIVE CHANGE:", "$"+startingBal , "$" + balance); // format for log
	log.writeToFile(out);// log action
	
	// display message for all items in customeyr bin
		for (Items item : itemBin ) {
			System.out.println(item.getMessage());
		}
		System.out.println();
	}

	
	
	
	
	
	
	
	// Return Price methods
	public BigDecimal returnPriceForKey(String x) {
		if (this.getInventory().get(x).isEmpty()) {
			return new BigDecimal("0.00");
		} else {
			return this.getInventory().get(x).peek().getPrice(); // return current machine's price for x slot
		}
	}

	
	
	
	
	// return formatted string
	public String returnFormattedInventoryForKey(String x) {
		if (!this.getInventory().get(x).isEmpty()) {
			String y = String.format("%6s%20s%20s%20s", x, this.getInventory().get(x).peek().getName(),
					this.getInventory().get(x).size(), "$" + this.getInventory().get(x).peek().getPrice());
			return y;
		}
		return "Empty";
	}

	// BigDecimal price = this.getInventory().get("A1").peek().getPrice(); // get
	// price at A1
	// System.out.println(this.getInventory().get("A1").peek().getPrice()); // print
	// price at A1

	// String name = this.getInventory().get("A1").peek().getName(); // get name at
	// A1
	// System.out.println(this.getInventory().get("A1").peek().getName()); // print
	// name at A1

	// String message = this.getInventory().get("A1").peek().getMessage(); // get
	// message at A1
	// System.out.println(this.getInventory().get("A1").peek().getMessage()); //
	// print message at A1

	// int invetory = this.getInventory().get("A1").size(); // get items left at A1
	// System.out.println(this.getInventory().get("A1").size()); // print items left
	// at A1

	// boolean empty = this.getInventory().get("A1").isEmpty(); // check if A1 is
	// empty
	// System.out.println(this.getInventory().get("A1").isEmpty()); // print if A1
	// is empty

	// this.getInventory().get("A1").pop(); //remove item from location A1
	// System.out.println(this.getInventory().get("A1").size()); // print items left
	// at A1

	
	
	
	
	
	// get current inventory
	public String printInventory() {
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println();
		System.out.format("%6s%20s%20s%20s%n", "Slot #", "ITEM NAME", "NUMBER LEFT", "PRICE");
		System.out.println();
		// loop through inventory
		for (String key : this.getInventory().keySet()) {
			System.out.println(this.returnFormattedInventoryForKey(key));
		}
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println();
		return "Done";
	}

	@SuppressWarnings("unchecked")
	public Map<String, Stack<Items>> getInventory() {
		return inventory;
	}

}
