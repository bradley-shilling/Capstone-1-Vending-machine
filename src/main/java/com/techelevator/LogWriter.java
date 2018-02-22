package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LogWriter {
	
	public void writeToFile (String input) throws FileNotFoundException {
		
		// add date format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		String date = new Date().toString();
		
		
		
		// write to file
				try(PrintWriter writer = new PrintWriter(new FileOutputStream(
					    new File("log.txt"), 
					    true /* append = true */))
						) {
					
							writer.printf("%-40s%-120s%n", date, input);
							
					}
				}	
	}	


