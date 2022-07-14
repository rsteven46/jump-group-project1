package com.cognixia.jump.InputValidation;

import java.util.Scanner;

public class InputValidation {
	public static int mainMenuValidation(Scanner scan, String regex) {
		String choice = scan.next();
		while(!choice.matches(regex)) {
			System.out.println("Wrong Input. Try again");
//			scan.nextLine();
			choice = scan.next();
		}
		
		return Integer.parseInt(choice);
	}
}
