import java.util.Scanner;

public class factorial {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(fact(n));
	}
	/*
	Need to fill the calculateFromDegreesToFarenheit function and print the output
	of fahrenheit.
	*/
	public static int fact(int a) {
		if(a==0)
			return 1;
		return a*fact(a-1);
	}
}