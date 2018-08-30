
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/

	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			// System.out.println("HELLO");
			String s = sc.nextLine();
			// System.out.println(s + "HI");
			String res = binaryToDecimal(s);
			System.out.println(res);
		}
	}

	/**
	 * { function_description }.
	 *
	 * @param      a     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String binaryToDecimal(final String a) {
		int count = 0;
		long b = Long.parseLong(a);
		long indi = 0;
		double num = 0;
		final int ten = 10;
		while (b > 0) {
			indi = b % ten;
			count++;
			num += indi * Math.pow(2, count - 1);
			b = b / ten;
		}
		int num1 = (int) num;
		return String.valueOf(num1);
	}


}

