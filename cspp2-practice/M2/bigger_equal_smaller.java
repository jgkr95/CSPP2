import java.util.Scanner;

public class bigger_equal_smaller {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b =scan.nextInt();
		check(a,b);
	}
	/*
	Need to fill the areaOfTriangle function and print the output
	of fahrenheit.
	*/
	public static void check(int a, int b) {
		if(a>b)
			System.out.println("Bigger");
		else if(a==b)
			System.out.println("Equal");
		else
			System.out.println("Smaller");
	}
}