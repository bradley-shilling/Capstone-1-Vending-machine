package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import javax.swing.text.MaskFormatter;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT,
			PURCHASE_MENU_FINISH_TRANSACTION };

	private static final String PURCHASE_MENU_FEED_MONEY_ONE = "Depost $1";
	private static final String PURCHASE_MENU_FEED_MONEY_TWO = "Depost $2";
	private static final String PURCHASE_MENU_FEED_MONEY_FIVE = "Depost $5";
	private static final String PURCHASE_MENU_FEED_MONEY_TEN = "Depost $10";
	private static final String PURCHASE_MENU_FEED_MONEY_CANCEL = "Cancel";
	private static final String[] PURCHASE_MENU_FEED_MONEY_OPTIONS = { PURCHASE_MENU_FEED_MONEY_ONE,
			PURCHASE_MENU_FEED_MONEY_TWO, PURCHASE_MENU_FEED_MONEY_FIVE, PURCHASE_MENU_FEED_MONEY_TEN, PURCHASE_MENU_FEED_MONEY_CANCEL };

	private static final String PURCHASE_MENU_SELECT = "Enter product slot key";
	private static final String[] PURCHASE_MENU_SELECT_ARRAY = { PURCHASE_MENU_SELECT };

	private static final String PURCHASE_MENU_FINALIZE = "Dispensing Items";
	private static final String[] PURCHASE_MENU_FINALIZE_ARRAY = { PURCHASE_MENU_FINALIZE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		VendingMachine vm = new VendingMachine();

		// BigDecimal price = vm.getInventory().get("A1").peek().getPrice(); // get
		// price at A1
		// System.out.println(vm.getInventory().get("A1").peek().getPrice()); // print
		// price at A1
		//
		// String name = vm.getInventory().get("A1").peek().getName(); // get name at A1
		// System.out.println(vm.getInventory().get("A1").peek().getName()); // print
		// name at A1
		//
		// String message = vm.getInventory().get("A1").peek().getMessage(); // get
		// message at A1
		// System.out.println(vm.getInventory().get("A1").peek().getMessage()); // print
		// message at A1
		//
		// int invetory = vm.getInventory().get("A1").size(); // get items left at A1
		// System.out.println(vm.getInventory().get("A1").size()); // print items left
		// at A1
		//
		// boolean empty = vm.getInventory().get("A1").isEmpty(); // check if A1 is
		// empty
		// System.out.println(vm.getInventory().get("A1").isEmpty()); // print if A1 is
		// empty
		//
		// vm.getInventory().get("A1").pop(); //remove item from location A1
		// System.out.println(vm.getInventory().get("A1").size()); // print items left
		// at A1

		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vm.printInventory();
				
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (choice.equals(PURCHASE_MENU_FEED_MONEY)) {
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_FEED_MONEY_OPTIONS);
						if (choice.equals(PURCHASE_MENU_FEED_MONEY_ONE)) { // feed money method
							vm.deposit(new BigDecimal("1.00"));
						} else if (choice.equals(PURCHASE_MENU_FEED_MONEY_TWO)) {
							vm.deposit(new BigDecimal("2.00"));
						} else if (choice.equals(PURCHASE_MENU_FEED_MONEY_FIVE)) {
							vm.deposit(new BigDecimal("5.00"));
						} else if (choice.equals(PURCHASE_MENU_FEED_MONEY_TEN)) {
							vm.deposit(new BigDecimal("10.00"));
						} else if (choice.equals(PURCHASE_MENU_FEED_MONEY_CANCEL)) {
						
						}
						
		
					} else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						vm.printInventory();
						// select item method
						vm.selectProduct();
						// ^ dispence item to customar bin this is called by product selection
		
					} else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION )) {
						vm.finalize();
						// return to main menu
						break;
					
					} else {
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
		
					}
				}

			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
}
