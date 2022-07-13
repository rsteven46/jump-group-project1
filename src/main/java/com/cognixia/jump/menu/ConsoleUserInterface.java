package com.cognixia.jump.menu;

import java.util.Scanner;

public class ConsoleUserInterface {
	
	public static void userPrompt(Scanner scan) {
		String username = null, password = null;
		
		System.out.println("*** Progress Tracker ***");
		System.out.println("\t\n Please enter username: ");
		username = scan.next();
		
		System.out.println("\t\n Please enter password: ");
		password = scan.next();
	}
	
}
