package com.cognixia.jump;

import java.util.Scanner;

import com.cognixia.jump.menu.ConsoleUserInterface;

public class ProgressDriver {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ConsoleUserInterface.userPrompt(scan);
		scan.close();
	
	}

}
