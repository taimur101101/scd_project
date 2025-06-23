package service;

import model.Book;
import java.util.ArrayList;

public class LibraryService {
	private ArrayList<Book> books= new ArrayList<>();
	
	// Add a book 
	public String addBook(String title) {
		if(title == null || title.trim().isEmpty()) {
			return "Error:Please Enter Book Title.";
		}
		for(int i=0; i<books.size(); i++) {
			if (books.get(i).getTitle().equalsIgnoreCase(title)) {
				return "Book already exists.";
			}
		}
		books.add(new Book(title));
		return "Book added:" + title;
	}
	// List all available book
	public String getAvailableBook() {
	    if (books.isEmpty()) {
	        return "No books in the library.";
	    }
	    StringBuilder availableBooks = new StringBuilder("Available Books:\n");
	    boolean found = false;
	    for (int i = 0; i < books.size(); i++) {
	        Book book = books.get(i);
	        if (!book.isBorrowed()) {
	            availableBooks.append("- ").append(book.getTitle()).append("\n");
	            found = true;
	        }
	    }
	    if (!found) {
	        return "No available books right now.";
	    }
	    return availableBooks.toString();
	}
	// Borrow a book by title
	public String borrowBook(String title) {
		if(title == null || title.trim().isEmpty()) {
			return "Error:Please Enter Book Title.";
		}
		for(int i=0; i<books.size(); i++) {
			Book book= books.get(i);
			if(book.getTitle().equalsIgnoreCase(title)) {
				if(!book.isBorrowed()) {
					book.borrow();
					return "Book borrowed:" + title;
				}
				else {
					return "Book is already borrowed.";
				}
			}
		}
		return "Error:Book Not Found";
	}
	// Return a book
	public String returnBook(String title) {
		if(title == null || title.trim().isEmpty()) {
			return "Error:Please Enter Book Title.";
		}
		for(int i=0; i<books.size(); i++) {
			Book book= books.get(i);
			if(book.getTitle().equalsIgnoreCase(title)) {
				if(book.isBorrowed()) {
					book.returnBook();
					return "Book returned:" + title;
				}
				else {
					return "Book was not borrowed.";
				}
			}
		}
		return "Error:Book Not Found";
	}
	// Search book by title
	public String searchBook(String title) {
		if(title == null || title.trim().isEmpty()) {
			return "Error:Please Enter Book Title.";
		}
		for(int i=0; i<books.size(); i++) {
			Book book= books.get(i);
			if(book.getTitle().equalsIgnoreCase(title)) {
				return "Book Found: " + book.getTitle() + "\nStatus: " + (book.isBorrowed() ? "Borrowed" : "Available");
			}
		}
		return "Error:Book Not Found";
	}
	
}
