/*Hamza Ilyas
 * hi3zk
 * Homework 2
 */

public class Book {
	
	//declaring private variables used in this class
	private String title;
	private String author;

	//create the Book constructor class
	public Book (String title, String author) {
		this.title = title;
		this.author = author;
	}

	//the getTitle class will return the title of the book when called
	public String getTitle () {
		return title;
	}

	//the  getAuthor class will return the author of the book when called
	public String getAuthor () {
		return author;
	}

	//the equals method checks if the books are equal
	public boolean equals (Object o) {
		if (o instanceof Book) {
			Book book1 = (Book) o;
			if (this.title == book1.title && this.author == book1.author) {
				/*the if statement checks if the original title and author is 
				 * equal to the newly created object's title and author.
				 */
				return true;
			}
		}
		return false;
	}

	//the toString method is a way to return the title and author in String format.
	public String toString () {
		return "Title: " + title + ", Author: " + author;
	}

}
