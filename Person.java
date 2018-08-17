/* Hamza Ilyas
 * hi3zk
 * Homework 2
 */

import java.util.ArrayList;

public class Person {

	//declaring variables to be used in the Person class
	private String name;
	private int id;
	private ArrayList<Book> read;

	//creating the Person constructor
	public Person (String name, int id) {
		this.name = name;
		this.id = id;
		this.read = new ArrayList<Book>();
	}
	
	//the getName method returns the name of the Person when called.
	public String getName() {
		return this.name;
	}

	//the setName method replaces an old name with a new name.
	public void setName(String name) {
		this.name = name;
	}
	
	//the getId method returns the id of the Person when called.
	public int getId() {
		return id;
	}

	//the setId method replaces an old id with a new id.
	public void setId(int id) {
		this.id = id;
	}

	//the getRead method returns the list of books the person has read.
	public ArrayList<Book> getRead() {
		return this.read;	
	}

	//the setRead method replaces the original arrayList to a new arrayList
	public void setRead(ArrayList<Book>read) {
		this.read = read;
	}

	//the addBook method adds a book to the read if it is not in the list.
	public boolean addBook(Book b) {
		if (!(this.read.contains(b))) {
			this.read.add(b);
			return true;
		}
		return false;
	}

	//the hasRead method is conditional upon whether a person has read a specific book.
	public boolean hasRead (Book b) {
		if (this.read.contains(b)) {
			return true;
		}
		return false;
	}

	//the forgetBook method will remove a book from the books read.
	public boolean forgetBook (Book b) {
		if (this.read.contains(b)) {
			this.read.remove(b);
			return true;
		}

		return false;
	}

	//the numBooksRead method will return how many books the person has read.
	public int numBooksRead() {
		int count = 0;
		for (int i = 0; i < read.size(); i++) {
			count++;	
		}

		return count;
	}
	
	//the equals method checks if the new Person's id is the same as another person's id.
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person p1 = (Person) o;
			if (this.id == p1.id) {
				return true;
			}
		}
		return false;
	}

	//the toString method returns a string of the Name, Id, and books a person read.
	public String toString() {
		return "Name: " + name + "ID: " + Integer.toString(id) + "Books read: " + read.toString();
	}

	//the commonBooks method returns an arrayList of books both people have read.
	public static ArrayList<Book> commonBooks(Person a, Person b) {
		ArrayList <Book> both = new ArrayList<Book>();
		for (int i = 0; i < a.read.size(); i++) {
			for (int k = 0; k < b.read.size(); k++) {
				if (a.read.get(i).equals(b.read.get(k))) {
					both.add(a.read.get(i));
				}
			}
		}
		return both;

	}

	//the similarity method returns values based on how similar the books are.
	public static double similarity(Person a, Person b) {
		//first if statement sets 0.0 if one of the people hasn't read any books.
		if (a.read.size() == 0 || b.read.size() == 0) {
			return 0.0;
		}
		else {
			int q = commonBooks(a,b).size();
			/*returns a boolean value of total number read by both divided
			*by the minimum of the two.
			*/
			if (a.read.size() > b.read.size()) {
				double num = q/(b.read.size());
				return num;
			}
			else {
				double num = q/((double)a.read.size());
				return num;
				
			}
		}
	}

	public static void main (String[] args) {
		//below are instances to test the methods above.
		Person p1 = new Person ("Jack", 83);
		Person p2 = new Person ("Arthur", 73);
		Book b1 = new Book("The Fault In Our Stars", "Green");
		Book b2 = new Book ("The Great Gatsby", "Fitzgerald");
		Book b3 = new Book ("The Catcher In The Rye", "Salinger");
		p1.addBook(b1);
		p1.addBook(b2);
		p1.addBook(b3);
		p2.addBook(b3);
		p2.addBook(b1);

		//System.out.println(p1.read);
		//System.out.println(p1.numBooksRead());
		//p1.forgetBook(b1);
		//System.out.println(p1.read);
		//System.out.println(p1.numBooksRead());
		System.out.println(similarity(p1,p2));
	}
}
