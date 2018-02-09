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

	// methods

	// deposit
	public void deposit(BigDecimal ammount) throws FileNotFoundException {
		balance = balance.add(ammount);// add amount to current balance
		// log action
		log.writeToFile("FEED MONEY:     $"+ ammount + "    $" + balance);// log action
		System.out.println("The current balance is " + "$" + balance.toString());
	}

	// select product
	public void selectProduct() throws FileNotFoundException {
		// User Interactions
		System.out.print("Whaddya Buyin'?: ");
		String selectedProduct = input.nextLine();
		// logic
		if (this.getInventory().containsKey(selectedProduct) && this.balance.compareTo(this.getInventory().get(selectedProduct).peek().getPrice()) >= 0) { // do if key is valid and balance is more than price																								
			dispence(selectedProduct);
			System.out.println("Dispensing " + this.getInventory().get(selectedProduct).peek().getName() + ".");
			//log action
			log.writeToFile(this.getInventory().get(selectedProduct).peek().getName() + "  " + selectedProduct + "    -$" + this.getInventory().get(selectedProduct).peek().getPrice() + "    $"+ balance);// log action
		} else if (this.getInventory().containsKey(selectedProduct)) {
			System.out.println("Not Enough Cash, Stranger.");
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
			System.out.println(balance + "Left");

		}

		return null;
	}
	
	// Finalize method
	public void finalize() throws FileNotFoundException {
		// make change
	Change change = new Change();
	System.out.println(change.makeChange(this.balance));
	
	// set balance to 0
	BigDecimal startingBal = balance;
	balance = new BigDecimal("0.00");
	// log action
	log.writeToFile("GIVE CHANGE:     $"+ startingBal + "    $" + balance);// log action
	
	// display message for all items in customeyr bin
		for (Items item : itemBin ) {
			System.out.println(item.getMessage());
		}
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

	// finish
	public void finish() {

		return;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Stack<Items>> getInventory() {
		return inventory;
	}

}
