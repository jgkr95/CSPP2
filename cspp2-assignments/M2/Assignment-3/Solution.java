/**
*Program for power using recursion
*/
import java.util.Scanner;
public class Solution {
	/**
	Do not modify this main function.
	*/
	public static int res = 1;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
	}
	
	public static long power(int b, int e) {
		/**
		*Need to write the power function and print the output.
		*/
		// int res = ;
		if(e == 0) {

			return 1;
		}
		else {
			return b * power(b, e-1);
		}
	}
}
