
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
		for(int i=0;i<=n;i++){
			// sc.nextLine();
			String s = sc.next();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static String binaryToDecimal(String a) {
		int count = 0;
		int b = Integer.parseInt(a);
		int indi = 0, num = 0;

		while (b > 0) {
			indi = b % 10;
			count++;
			num += indi * Math.pow(2, count-1);
			b = b / 10;
		}
		return String.valueOf(num);
	}


}

