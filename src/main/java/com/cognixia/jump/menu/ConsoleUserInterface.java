package com.cognixia.jump.menu;

import java.util.Scanner;

import com.cognixia.jump.DAO.UserDAO;
import com.cognixia.jump.model.User;

public class ConsoleUserInterface {
	
	private static int id = 0;
	
	public static void userPrompt(Scanner scan) {
		String username = null, password = null;
		
		System.out.println("*** Progress Tracker ***");
		
		System.out.println("\t\n Please enter username: ");
		username = scan.next();
		
		System.out.println("\t\n Please enter password: ");
		password = scan.next();
		
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		id = dao.verifyUser(user);
		
		
	}
	
}
