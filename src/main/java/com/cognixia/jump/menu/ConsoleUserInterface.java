package com.cognixia.jump.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.DAO.BookDAO;
import com.cognixia.jump.DAO.TrackerDAO;
import com.cognixia.jump.DAO.UserDAO;
import com.cognixia.jump.InputValidation.InputValidation;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.Tracker;
import com.cognixia.jump.model.User;

public class ConsoleUserInterface {

	private static int id = 0;

	public static void userPrompt(Scanner scan) {
		String username = null, password = null;

		System.out.println("\t\t*** Progress Tracker ***");

		while (id == 0) {
			try {
				System.out.println("\t\nPlease enter username: ");
				// username = scan.next();

				System.out.println("\t\nPlease enter password: ");
				// password = scan.next();

				username = "Zainal";
				password = "Password";

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
		int userInput = 0;
		boolean exitStatus = false;

		while (exitStatus == false) {
			System.out.println("\nPlease choose your menu:");

			System.out.println("\n1. View book list\n" + "2. Update process\n" + "3. Add a book\n"
					+ "4. Remove a book\n" + "5. Exit");

			userInput = InputValidation.mainMenuValidation(scan, "^[1234]{1}$");

			switch (userInput) {
			case 1:
				// List all view
				listView(scan);
				mainMenu(scan);
				break;
			case 2:
				// Update process view
				updateProgressView(scan);
				break;
			case 3:
				// Add a book view
				addBookView(scan);
				break;
			case 4:
				// Remove a book view
				break;
			case 5:
				String response = null;
				System.out.println("\nDo you want to log out? [Y/N]");
				response = scan.next();
				if (response == "y" || response == "Y") {
					id = 0;
					userPrompt(scan);
				}
			}
		}
	}

	public static void listView(Scanner scan) {
		// variables
		int bookID;

		// created objects
		TrackerDAO tDao = new TrackerDAO();
		BookDAO bDao = new BookDAO();

		List<Tracker> trackers = new ArrayList<Tracker>();

		trackers = tDao.findByUserId(id);

		List<Book> books = new ArrayList<Book>();

		books = bDao.findByName(trackers);

		for (Book book : books) {
			System.out.println(book);
		}

	}

	public static void updateProgressView(Scanner scan) {
		int userInput = 0;
		System.out.println("\nPlease choose your menu:");
		System.out.println("\n1. Enter Book Name " + "\n2. Go Back to previous menu\n");
		userInput = InputValidation.mainMenuValidation(scan, "^[12]{1}$");

		switch (userInput) {
		case 1:
			searchBookPrompt(scan);
			break;
		case 2:
			mainMenu(scan);
			break;
		}

	}

	private static void searchBookPrompt(Scanner scan) {
		BookDAO bDao = new BookDAO();

		System.out.println("\nPlease enter Book name to update:");
		scan.nextLine();
		String bookName = scan.nextLine();

		Book book = bDao.findByName(bookName);
		updateStatusView(book, scan);
	}

	private static void updateStatusView(Book book, Scanner scan) {
		int userInput = 0;
		Tracker track = new Tracker();
		TrackerDAO tDao = new TrackerDAO();
		
		System.out.println(
				"\nPlease choose your status:" + "\n1. Not started\n" + "2. Started\n" + "3. Complete\n" + "4. Go Back");

		userInput = InputValidation.mainMenuValidation(scan, "^[1234]$");

		switch (userInput) {
		case 1:
			//update status to not started
			track =tDao.findByCompositeId(id, book.getBookID());
			track.setProgressStatus("Not Started");
			
			if(tDao.update(track)) {
				System.out.println("\n\t *** Record updated ***");
			}
			System.out.println(track.getProgressStatus());
			
			break;
		case 2:
			// Update status to started
			track =tDao.findByCompositeId(id, book.getBookID());
			track.setProgressStatus("Started");
			
			if(tDao.update(track)) {
				System.out.println("\n\t *** Record updated ***");
			}
			System.out.println(track.getProgressStatus());
			
			break;
		case 3:
			// update status to completed
			track =tDao.findByCompositeId(id, book.getBookID());
			track.setProgressStatus("Completed");
			
			if(tDao.update(track)) {
				System.out.println("\n\t *** Record updated ***");
			}
			System.out.println(track.getProgressStatus());
			
			break;
		case 4:
			// Remove a book view
			
			break;
		}
	}

	public static void addBookView(Scanner scan) {
		TrackerDAO tDao = new TrackerDAO();

		List<Tracker> tList = tDao.findByUserId(id);

		List<Integer> bookIDList = new ArrayList<>();
		Integer bookID = 0;

		for (Tracker tracker : tList) {
			System.out.println(tracker.getBookID());
			bookID = tracker.getBookID();
			bookIDList.add(bookID);
		}

		BookDAO bDao = new BookDAO();
		List<Book> blist = bDao.findAll();
		
		for (int i = 0; i < blist.size(); i++) {
			
			int bID = blist.get(i).getBookID();
			
			
			for (int j = 0; j < bookIDList.size(); j++) {
			
				if(bookIDList.get(j) == bID) {

					blist.remove(i);
					continue;
				}
			}

		}
		blist.forEach(System.out::println);
		
	System.out.println("Please enter a book name from the list above to add to your progress tracker");
	scan.nextLine();
	String userAddedBook;
	
	userAddedBook=scan.nextLine();
	int newbid;
		for(int i = 0; i < blist.size(); i++) {
				
			if(userAddedBook.equals(blist.get(i).getName())  ) {
					newbid=blist.get(i).getBookID();
					Tracker newTracker= new Tracker(id,newbid,"Not Started");		
					tDao.create(newTracker);
					System.out.println("Added to your list you nerd");
					
				}
		}
		
	}

	public static void removeBookView(Scanner scan) {

	}

}
