package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class inventoryReader  {

	public Map<String, Stack<Items>> generateInventory() throws FileNotFoundException {
		
		File inputFile = new File("vendingmachine.csv"); // import the file
		Scanner fileReader = new Scanner(inputFile); // make a new scanner for file
		
		/*
		 * logic
		 */
		//create map array
		Map<String, Stack<Items>> inventory = new HashMap<>();
		
		
		//run through file
		while (fileReader.hasNextLine()) {//run while next line
			String currentLine = fileReader.nextLine(); // get line from file
			if (!currentLine.isEmpty()) {
				String[] properties = null; 
				properties = currentLine.split("\\|"); // store items properties in array
				// get slot / key
				String key = properties[0];  
				// create stack for slot
				Stack<Items> currentStack = new Stack<Items>();
				// create item  && if key statement
				if (properties[0].contains("a") || properties[0].contains("A")) {
					ChipsItem currentItem = new ChipsItem(properties[1], new BigDecimal(properties[2]));// create item
					for (int i = 0; i<5; i++ ) { // add to stack 5 time
						currentStack.add(currentItem);
						}
				} else if (properties[0].contains("b") || properties[0].contains("B")) {
					CandyItem currentItem = new CandyItem(properties[1], new BigDecimal(properties[2]));// create item
					for (int i = 0; i<5; i++ ) { // add to stack 5 time
						currentStack.add(currentItem);
						}
				} else if (properties[0].contains("c") || properties[0].contains("C")) { 
					BeverageItem currentItem = new BeverageItem(properties[1], new BigDecimal(properties[2]));// create item
					for (int i = 0; i<5; i++ ) { // add to stack 5 time
						currentStack.add(currentItem);
						}
				} else if (properties[0].contains("d") || properties[0].contains("D")) {
					GumItem currentItem = new GumItem(properties[1], new BigDecimal(properties[2]));// create item
					for (int i = 0; i<5; i++ ) { // add to stack 5 time
						currentStack.add(currentItem);
						}
				}
				inventory.put(properties[0], currentStack); // add stack to map
			}
			

			
		}
		
		return inventory; // return inventory
		
	}

}
