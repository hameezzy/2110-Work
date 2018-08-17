import static org.junit.Assert.*;

import org.junit.Test;

public class HW2Test {
	
	//tests for numCopies methods
	@Test(timeout=100)
	public void checkNumCopies1(){
		Library libraryBook11 = new Library("hello friend");
		Book a = new Book ("divergent", "idk", 234333,2333343.0);
		Book b = new Book("harry potter", "JK rowling", 70, 70.0);
		libraryBook11.getLibraryBooks().add(a);
		libraryBook11.getLibraryBooks().add(b);
		int c = libraryBook11.checkNumCopies("harry potter", "JK rowling");
		assertTrue(c == 1);
	}
	@Test(timeout=100)
	public void checkNumCopies2(){
		Library libraryBook12 = new Library("hello everyone");
		Book a = new Book ("pride and prejudice", "Austen", 231214,23212143.0);
		Book b = new Book("harry potter2", "JK rowling", 20, 20.0);
		Book d = new Book("harry potter2", "JK rowling", 20, 20.0);
		libraryBook12.getLibraryBooks().add(a);
		libraryBook12.getLibraryBooks().add(b);
		libraryBook12.getLibraryBooks().add(d);

		int c = libraryBook12.checkNumCopies("harry potter2", "JK rowling");
		assertTrue(c == 2); 
	}
	

	//tests for totalNumBooks method
	@Test(timeout=100)
	public void checktotalNumBooks1() {
		Library libraryBook13 = new Library("bye everyone");
		Book a = new Book ("pride and prejudice", "Austen", 231214,23212143.0);
		Book b = new Book("harry potter2", "JK rowling", 20, 20.0);
		Book c = new Book("harry potter3", "JK rowling", 10, 10.0);
		Book d = new Book ("hunger games", "suzanne", 234,2343.0);
		Book e = new Book("some title", "some author", 0, 0.0);
		libraryBook13.getLibraryBooks().add(a);
		libraryBook13.getLibraryBooks().add(b);
		assertTrue(libraryBook13.totalNumBooks() == 2); 
	}
	
	//tests for checkOut method
	@Test(timeout=100)
	public void checkcheckout1(){
		Library libraryBook14 = new Library("chinn park");
		Book a = new Book ("divergent", "idk", 21,23.0);
		Book b =new Book("harry potter and the chamber of secrets", "JK rowling", 70, 70.0);
		String dueDate = "11 06 2003";
		b.setDueDate(dueDate);
		b.setCheckedOut(true);
		assertTrue(b.isCheckedOut()== true);
	}
	@Test(timeout=100)
	public void checkcheckout2(){
		Library libraryBook1a = new Library("AlderMANZ");
		Book a = new Book ("flowers for algernon", "Daniel Keyes", 21,23.0);
		Book b =new Book("twilight", "Steponme Meyer", 711, 1.4);
		String dueDate = "1 30 2013";
		b.setDueDate(dueDate);
		b.setCheckedOut(true);
		assertFalse(b.isCheckedOut()== false);
	}

	
	//tests for booksDueOnDate method
	@Test(timeout=100)
	public void checkbooksDueOnDate(){
		Library	libraryBook15= new Library("Clark or is it Brown?");
		Book a = new Book ("What do you call an egg that's turnt?", "om-LIT", 1999,2000.0);
		Book b = new Book("please let me pass", "thanks", 11, 12311.0);
		String dueDate = "11 06 2003";
		String dueDate1 = "11 06 2003";
		a.setDueDate(dueDate);
		b.setDueDate(dueDate1);
		a.getDueDate().equals(dueDate);
		b.getDueDate().equals(dueDate1);
		assertTrue(b.getDueDate() == a.getDueDate());
	}
	@Test(timeout=100)
	public void checkbooksDueOnDate2(){
		Library	libraryBook1b= new Library("Club Clem or naw?");
		Book a = new Book ("What did the shy pebble wish for?", "to be a little boulder", 1969,2600.0);
		Book b = new Book("What do you call a guy with a toe made out of rubber?", "Roberto", 1001, 111.0);
		String dueDate = "11 06 2003";
		String dueDate1 = "11 06 2013";
		a.setDueDate(dueDate);
		b.setDueDate(dueDate1);
		a.getDueDate().equals(dueDate);
		b.getDueDate().equals(dueDate1);
		assertTrue(b.getDueDate() != a.getDueDate());
	}

	
	//tests for lateFee method
	@Test(timeout=100)
	public void checklateFee1(){
		Library	libraryBook16= new Library("special collections YASSS");
		String OGdate = "12 09 2016";
		String duedate = "23 09 2016";
		Person a  = new Person("joe", "smith", 10);
		Book b = new Book("OMG", "lol",654,10.00);
		libraryBook16.getPatrons().add(a);
		libraryBook16.getLibraryBooks().add(b);
		libraryBook16.checkOut(a, b, OGdate);
		libraryBook16.setCurrentDate(duedate);
		//System.out.println(libraryBook16.lateFee(a));
		assertTrue(libraryBook16.lateFee(a)==0.0);
	}
	@Test(timeout=100)
	public void checklateFee2(){
		Library	library= new Library("special collections ehh");
		String OGdate = "12 09 2016";
		String duedate = "13 09 2016";
		Person f  = new Person("bob", "smith", 10);
		Book b = new Book("hhaha", "lol",622,10.00);
		library.getPatrons().add(f);
		library.getLibraryBooks().add(b);
		library.checkOut(f, b, OGdate);
		library.setCurrentDate(duedate);
		//System.out.println(library.lateFee(f));
		assertTrue(library.lateFee(f)==0.0);
	}
	
	//sort tests by name
	@Test(timeout=100)
	public void TestsortByName(){
	}
}