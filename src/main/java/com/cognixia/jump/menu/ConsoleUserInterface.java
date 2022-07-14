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

		System.out.println(" Progress Tracker ");

		while (id == 0) {
			try {
				System.out.println("\t\n Please enter username: ");
				username = scan.next();

				System.out.println("\t\n Please enter password: ");
				password = scan.next();

				UserDAO dao = new UserDAO();
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);

				id = dao.verifyUser(user);
			} catch (Exception e) {
				System.out.println("Please try again..");
			}
		}

		mainMenu(scan);

	}

	public static void mainMenu(Scanner scan) {

		System.out.println("Please choose your menu:");

		System.out.println("1. View book list\n" + "2. Update process\n" + "3. Add a book\n" + "4. Remove a book");

		int userInput = scan.nextInt();

		switch (userInput) {

		case 1:
			// List all view
			listView(scan);
			break;
		case 2:
			// Update process view
			updateProgressView(scan);
			break;
		case 3:
			// Add a book view
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

	public static void updateProgressView(Scanner scan) {

		BookDAO bDao = new BookDAO();

		System.out.println("Please choose your menu:");

		System.out.println("1. Enter Book Name: " + "2. Go Back\n");

		int userInput = scan.nextInt();

		switch (userInput) {

		case 1:
			System.out.println();
			String bookName = scan.nextLine();
			Book book = bDao.findByName(bookName);
			updateStatusView(book, scan);
			break;
		case 2:
			// Update process view
			break;

		}

	}
	
	private static void updateStatusView(Book book, Scanner scan) {
		
		TrackerDAO tDao = new TrackerDAO();
		
		System.out.println("Please choose your status:");

		System.out.println("1. Not started\n" + "2. Started\n" + "3. Complete\n" + "4. Go Back");

		int userInput = scan.nextInt();

		switch (userInput) {

		case 1:
			System.out.println(id);
			break;
		case 2:
			// Update process view
			break;
		case 3:
			// Add a book view
			break;
		case 4:
			// Remove a book view
			break;
		}
	}

	public static void addBookView(Scanner scan) {

	}

	public static void removeBookView(Scanner scan) {

	}

}
