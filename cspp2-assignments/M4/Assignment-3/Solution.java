
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++){
			// System.out.println("HELLO");
			String s = sc.nextLine();
			// System.out.println(s + "HI");
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static String binaryToDecimal(String a) {
		int count = 0;
		System.out.println(a);
		long b = Integer.parseInt(a);
		long indi = 0, num = 0;
		final int ten = 10;
		while (b > 0) {
			indi = b % ten;
			count++;
			num += indi * Math.pow(2, count-1);
			b = b / ten;
		}
		return String.valueOf(num);
	}


}

