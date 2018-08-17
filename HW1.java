//Computing id: hi3zk

import java.util.Scanner;
public class HW1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("How many digits of pi would you like?");
		int value = input.nextInt();
		System.out.println(pi(value));
		
		System.out.println(" ");

		
		Scanner input2 = new Scanner(System.in);
		System.out.println("Please choose a year:");
		int value2 = input2.nextInt();
		System.out.println(easter(value2));
		
		System.out.println(" ");

		
		Scanner input3 = new Scanner(System.in);
		System.out.println("What is the launch velocity?");
		double value3 = input3.nextInt();
		System.out.println(escape(value3));
		
		System.out.println(" ");
		
		Scanner input4 = new Scanner(System.in);
		System.out.println("Please list 4 values;");
		int value4 = input4.nextInt();
		int value5 = input4.nextInt();
		int value6 = input4.nextInt();
		int value7 = input4.nextInt();
		
		int[] w = new int[0];
		w= random(value4,value5, value6, value7);
		

		System.out.println(java.util.Arrays.toString(w));
		//System.out.println(random(value4,value5, value6, value7));

		
	}

	public static double pi(int n) {
		// TODO Auto-generated method stub
		double pi = 0;
		double den = 1;
		for (int i = 1; i <100000000; i ++){
			
			if( i %2 ==0){
				pi = pi - (1/den);
			}
			else if (i%2 ==1){	
				pi = pi + (1/den);
				
			}
			den = den + 2;
		}
		double answer = pi*4;
		String answer1 =Double.toString(answer);
		answer1 = answer1.substring(0,n+2);
		double answer2= Double.parseDouble(answer1);
		return answer2;
	
		
	}



	public static String easter(int y){
		int a = y%19;
		int b = y/100;
		int c = y%100;
		int d = b/4;
		int e = b%4;
		int g = (8*b+13) /25;
		int h = (19*a+b-d-g+15) %30;
		int j = c/4;
		int k = c%4;
		int m = (a+11*h) /319;
		int r = (2*e+2*j-k-h+m+32)%7;
		int n =(h-m+r+90)/25;
		int p = (h-m+r+n+19) % 32;
		
		String theMonth = Integer.toString(n);
		String theDate = Integer.toString(p);
		String easterDate = "In " + y + " Easter Sunday is on " + theMonth + "/" + theDate;
		return easterDate;
		
	}
	
	public static String escape(double v){
		double G = 6.67*Math.pow(10, -11);
		double M = 1.3*Math.pow(10, 22);
		double R = 1.153*Math.pow(10, 6);
		v = v*0.44704;
		double escapeFormula = Math.sqrt((2*G*M)/R);
		String answerr =Double.toString(escapeFormula);
		double newMass = ((v*2)*(R))/(2*G);
		String number =Double.toString(newMass);
		if (v >= escapeFormula){
			double answer = M - newMass;
			String statement2 = " The astronaut will not return to Halley's comet. In order for the astronaut to return, the comet would need to have a mass larger than " + answer+ " kg";
			return statement2;
		}
		else{
			String statement = " The astronaut will return to Halley's comet";
			return statement;

			
		} 
	}
	


	
	
	public static int[] random(int r, int a, int b, int m){
		int f1=r;  
		 String answer;
		 int[] array= new int[25];
		for (int i = 0; i <25; i ++){
			 int formula = ((a*f1+b)%m);
		
			array[i] = formula;
			 f1=formula;
			 
		}
		return array;

	}
}

