import java.util.ArrayList;

import java.util.Calendar;
//import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
// https://docs.oracle.com/javase/7/docs/api/java/util/GregorianCalendar.html



public class Library {

	//declaring private variables that will be used in this class
	private static ArrayList<Book> libraryBooks = new ArrayList<Book> ();
	private ArrayList<Person> patrons = new ArrayList<Person> ();
	private String name;
	private int numBooks;
	private int numPeople;
	private String currentDate;

	//constructor class for the library
	public Library(String name){
		this.name = name;
		this.numPeople = patrons.size();
		this.numBooks = libraryBooks.size();
		libraryBooks = new ArrayList<Book>();
	}

	//needed to retrieve the list of library books
	public ArrayList<Book> getLibraryBooks() {
		return libraryBooks;
	}

	//needed to modify the list of library books
	public void setLibraryBooks(ArrayList<Book> libraryBooks) {
		this.libraryBooks = libraryBooks;
		this.numBooks = libraryBooks.size();
	}

	//needed to retrieve the list of patrons in the library
	public ArrayList<Person> getPatrons() {
		return patrons;
	}

	//needed to modify the list of patrons in the library
	public void setPatrons(ArrayList<Person> patrons) {
		this.patrons = patrons;
		this.numPeople = patrons.size();
	}

	//needed to retrieve the name of the person in the library
	public String getName() {
		return name;
	}

	//needed to modify the name of the person in the library
	public void setName(String name) {
		this.name = name;
	}

	//needed to retrieve number of people in the library
	public int getNumPeople() {
		this.numPeople = patrons.size();
		return patrons.size();
	}

	//needed to retrieve number of books in the library
	public int getNumBooks() {
		int counter = 0;
		for ( int i = 0; i < libraryBooks.size(); i++ ){
			if (libraryBooks.get(i).isCheckedOut() == false){
				counter += 1;
			}
		}
		return counter;

	}

	//needed to modify number of books in the library
	public void setNumBooks(int numBooks) {
		this.numBooks = numBooks;
	}

	//needed to modify number of people in library
	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}

	//needed to retrieve the date
	public String getCurrentDate() {
		return currentDate;
	}

	//needed to modify the date
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	//method to return the number of copies in the library of a specific book.
	public int checkNumCopies(String title, String author){
		int numbooks = 0;
		for ( int i = 0; i < libraryBooks.size(); i++ ){
			if(libraryBooks.get(i).getTitle().equals(title)&&libraryBooks.get(i).getAuthor().equals(author) ){
				numbooks +=1;
			}
		}
		return numbooks;

	}	
	
	//method to return the total number of books in the library
	public int totalNumBooks(){
		return libraryBooks.size();
	}

	//method to checkout a book only if the person is a patron and update the due date.
	public boolean checkOut(Person p, Book b, String dueDate) {
		if( !patrons.contains(p) || !libraryBooks.contains(b)) { 
			return false;
		}
		if ((libraryBooks.get(libraryBooks.indexOf(b)).isCheckedOut()) == false){
			p.getCheckedOut().add(libraryBooks.get(libraryBooks.indexOf(b)));
			libraryBooks.get(libraryBooks.indexOf(b)).setDueDate(dueDate);
			libraryBooks.get(libraryBooks.indexOf(b)).setCheckedOut(true);
			return true;
		}
		return false;
	}



	//method to list the books due on a given date
	public ArrayList<Book> booksDueOnDate(String date){
		ArrayList<Book> DUE = new ArrayList<Book> ();
		for ( int i = 0; i < libraryBooks.size(); i++ ){
			if(libraryBooks.get(i).getDueDate().equals(date)){
				DUE.add(libraryBooks.get(i));
			}
		}
		return DUE;

	}

	//the lateFee method calculates how much a person owes total for overdue books.
	public double lateFee (Person p) {
		//getting a value in milliseconds from the calendar method for the current Date
		double totalFees = 0.0;
		Integer day = Integer.parseInt(this.currentDate.substring(0, 2));
		Integer month = Integer.parseInt(this.currentDate.substring(3, 5));
		Integer year = Integer.parseInt(this.currentDate.substring(6, 10));
		GregorianCalendar x = new GregorianCalendar (day, month, year);
		long secs = x.getTimeInMillis();

		//getting a value in milliseconds from the calendar method for the due Date
		//both the dueDate and currentDate values will be compared 
		if (patrons.contains(p)) {
			for (Book b1: p.getCheckedOut()) {
				Integer day2 = Integer.parseInt(b1.getDueDate().substring(0,2));
				Integer month2 = Integer.parseInt(b1.getDueDate().substring(3,5));
				Integer year2 = Integer.parseInt(b1.getDueDate().substring(6,10));
				GregorianCalendar y = new GregorianCalendar (day2, month2, year2);
				long secs1 = y.getTimeInMillis();
				long difference = secs1 - secs;
				long conversion = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
				//if the difference is a nonnegative, sum up the fees
				if (difference > 0) {
					double fee = b1.getBookValue()*conversion*0.01;
					totalFees = totalFees + fee;
				}
			}
		}
		return totalFees;
	}
}
