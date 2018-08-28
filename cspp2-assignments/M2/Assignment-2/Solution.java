import java.util.Scanner;

public class Solution {
	/**
		* @param args Do not modify this main function.
	*/
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt(); 
		int c = scan.nextInt();
		rootsOfQuadrati(a, b, c);
	}
	/**
		*@param a,b,c Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	public static void rootsOfQuadrati(final int a, final int b, final int c) {
		final int i = 4, j = 2;
		double r1 = (-b - Math.sqrt((b * b) - (i * a * c)))/ (j * a);
		double r2 = (-b + Math.sqrt((b * b) - (i * a * c)))/ (j * a);
		System.out.println(r2+" "+r1);
		// System.out.println(r2);
	}
}
