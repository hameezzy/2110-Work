import java.awt.Color;

public class Recursion {
	
	//Problem 1
	public static String reverseString(String word) {

		//base case: checks if the string is empty; if it is, the word is returned
		if (word.isEmpty()) {
			return word;
		}
		
		//recursive case: the reason the word.charAt is at the end is so that the first letter is added at the end
		else {
			String newString = reverseString(word.substring(1)) + word.charAt(0) ;
			return newString;
		}
	}
	
	
	//Problem 2
	private static int [] array1 = new int [1000];
	
	public static int numPossibilities (int numStairs) {
		if (numStairs <= 0) {
			throw new UnsupportedOperationException ("use a positive number");
		}
		
		//what follows are the 3 base cases when numStairs is 1,2,3
		else if (numStairs == 1 ) {
			return 1;
		}
		
		else if (numStairs == 2) {
			return 2;
		}
		
		else if (numStairs == 3) {
			return 3;
		}
		
		//this  helper method has the possibilities minus the base cases
		int m1 = countWays (numStairs - 1);
		int m2 = countWays (numStairs - 2);
		
		return m1 + m2;
	}
	
	//main recursive method
	public static int countWays (int numStairs) {
		
		if (array1[numStairs] == 0) {
			int numPoss = numPossibilities (numStairs);
			array1[numStairs] = numPoss;
		}
		
		
		return array1[numStairs];	
	}
	
	
	//Problem 3
	public static int Ackermann (int m, int n) {
		
		//base case where m is 0
		if (m == 0) {
			return n + 1;
		}
		
		//recursive case when n is 0
		else if (m > 0 && n == 0) {
			return Ackermann (m - 1, 1);
		}
		
		//recursive case for all other possibilities
		else {
			return Ackermann (m - 1, Ackermann(m, n - 1));
		}
	}
	
	//Problem 4
	public static int handShakes (int n) {
		
		//people must be greater than 1 for a handshake
		if (n <= 1) {
			throw new UnsupportedOperationException ("use a number greater than 1");
		}
		
		//base case: 2 ppl will have one handshake
		if (n == 2) {
			return 1;
		}
		
		//recursive case: number of people - 1 all the way through added up
		else {
			return handShakes(n - 1) + n - 1;
		}
	}
	
	//Problem 5
	
	//helper method
	public static double squareRootGuess (double x, double g) {
		
		//base case: when the square is zero, return 0
		if (g * g == 0) {
			return 0;
		}
		
		//if the guess is really close return the guess
		else if (Math.abs(x - (g * g)) <= .0001) {
			return g;
		}
		
		//keep going till the guess is close
		else { 
			return squareRootGuess(x, ((g + (x/g))/2));
		}
		
	}
	
	//main recursive method that uses the helper method to computer sqrt
	public static double squareRoot (double x) {
		return squareRootGuess (x, x - 1);
	}
	
	
	//Problem 6
	
	//helper method 
	private static void kochSide (Turtle t, double number, double size) {
		t.putPenDown();
		
		//base case: checks if the number is 0, pen goes forward for the whole size
		if (number == 0) {
			t.forward(size);
		}
		
		//recursive cases: go down a number and do the same with a third of the size
		else {
			kochSide(t, number - 1, (size)/3);
			t.left(60);
			kochSide(t, number - 1, (size)/3);
			t.right(120);
			kochSide(t, number - 1, (size)/3);
			t.left(60);
			kochSide(t, number - 1, (size)/3);
		}
	}
	
	//main recursive method
	public static void snowflake (Turtle t, double number, double size) {
		//specifically draws  the snowflake using the helper method above
		kochSide(t, number, size);
		t.right(120);
		kochSide(t, number, size);
		t.right(120);
		kochSide(t, number, size);
	}
	
	
	
	public static void main(String[] args) {
		//Problem 1 Test
		System.out.println("Problem 1 Test 1");
		String reverse = reverseString("apple");
		System.out.println("Reverse of apple is " + reverse);
		System.out.println("Expected: elppa");
		System.out.println();
		
		System.out.println("Problem 1 Test 2");
		String reverse2 = reverseString("banana");
		System.out.println("Reverse of banana is " + reverse2);
		System.out.println("Expected: ananab");
		System.out.println();
		
		//Problem 2 Tests
		System.out.println("Problem 2 Test 1");
		System.out.println("For 5 steps: " + numPossibilities(5));
		System.out.println("Expected: 8");
		System.out.println();
		
		System.out.println("Problem 2 Test 2");
		System.out.println("For 10 steps: " + numPossibilities(10));
		System.out.println("Expected: 89");
		System.out.println();
		
		//Problem 3 Tests
		System.out.println("Problem 3 Test 1");
		System.out.println("Ackermann (2,7) is: " + Ackermann(2,7));
		System.out.println("Expected: 17");
		System.out.println();
		
		System.out.println("Problem 3 Test 2");
		System.out.println("Ackermann (3,4) is: " + Ackermann(3,4));
		System.out.println("Expected: 125");
		System.out.println();
		
		//Problem 4 Tests
		System.out.println("Problem 4 Test 1");
		System.out.println("5 people will have " + handShakes(5) + " handshakes");
		System.out.println("Expected: 10");
		System.out.println();
		
		System.out.println("Problem 4 Test 2");
		System.out.println("10 people will have " + handShakes(10) + " handshakes");
		System.out.println("Expected: 45");
		System.out.println();
		
		//Problem 5 Tests
		System.out.println("Problem 5 Test 1");
		System.out.println("The square root of 69 is " + squareRoot(69));
		System.out.println("Expected: 8.307");
		System.out.println();
		
		System.out.println("Problem 5 Test 2");
		System.out.println("The square root of 5 is " + squareRoot(5));
		System.out.println("Expected: 2.236");
		System.out.println();
		
		//Problem 6 Tests
		World w = new World (900, 900, Color.WHITE);
		w.setTitle("Tests 1 and 2");
		Turtle tuttle  = new Turtle(w);
		tuttle.setColor(Color.BLUE);
		tuttle.setDelay(.01);
		tuttle.pickPenUp();
		tuttle.goTo(-100, 100);
		snowflake(tuttle, 3, 250);
		
		
		Turtle tuttlee = new Turtle (w);
		tuttlee.setColor(Color.BLACK);
		tuttlee.setDelay(0);
		tuttlee.pickPenUp();
		tuttlee.goTo(-100, -100);
		snowflake(tuttlee, 5, 250);
		
	}
}
