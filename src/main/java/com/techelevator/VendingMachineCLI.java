package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items"; 
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	
	
	
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() throws FileNotFoundException {
		VendingMachine vm = new VendingMachine();
		
		while(true) {
			
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				// loop through keys
				Iterator it = vm.getInventory().entrySet().iterator(); // set up an iterator for main map
				while (it.hasNext()) {
					Map.Entry currentSlot = (Map.Entry)it.next(); // store  current keyed item
			        System.out.println(currentSlot.getKey() + " = " + currentSlot.getValue()); // test print stacks
			        // loop through stack for  current key
			       // Stack<Items> currentSlotsItems = currentSlot.getValue();
			        /*
			         * 
			         * working here
			         * 
			         * 
			         * 
			         */
			        
			        
			        
			        it.remove(); // avoids a ConcurrentModificationException
			      
			    }
				
				
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				
				
				// do purchase
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		
	} 
}
