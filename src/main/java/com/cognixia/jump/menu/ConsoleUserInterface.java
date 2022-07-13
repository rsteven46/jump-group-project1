package com.cognixia.jump.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.DAO.BookDAO;
import com.cognixia.jump.DAO.TrackerDAO;
import com.cognixia.jump.DAO.UserDAO;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.Tracker;
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
		
		mainMenu(scan);
		
		
	}
	
	public static void mainMenu(Scanner scan) {
		
		System.out.println("Please choose your menu:");
		
		System.out.println("1. View book list\n" 
				+ "2. Update process\n"
				+ "3. Add a book\n"
				+ "4. Remove a book");
		
		int userInput = scan.nextInt();
		
		switch(userInput) {
		
		case 1:
			//List all view
			listView(scan);
			break;
		case 2:
			//Update process view
			break;
		case 3:
			//Add a book view
			break;
		case 4:
			// Remove a book view
			break;
		}
	}
	
	public static void listView(Scanner scan) {
		
		TrackerDAO tDao = new TrackerDAO();
		BookDAO bDao = new BookDAO();
		
		int bookID;
		
		List<Tracker> trackers = new ArrayList<Tracker>();
		
		trackers = tDao.findByUserId(id);
		
		List<Book> books = new ArrayList<Book>();
		
		books = bDao.findByName(trackers);
		
		for (Book book : books) {
			System.out.println(book);
		}
		
		
	}
	public static void updateProcessView(Scanner scan) {
		
		
	}
	
	public static void addBookView(Scanner scan) {
		
		
	}
	
	public static void removeBookView(Scanner scan) {
		
		
	}
	
	
	
}
