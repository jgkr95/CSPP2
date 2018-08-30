
// Given an String, Write a java method that returns the decimal value for the given binary string.

import java.util.Arrays;

import java.util.Scanner;
public class Solution {
	/*
	Do not modify the main function 
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String reverse=reverseString(s);	
		System.out.println(reverse);
		
	}
	//Write reverseString function
	public static String reverseString(final String s) {
		// System.out.println(Arrays.toString(s));
		// String[] a = Arrays.toString(s);
		// System.out.println(a);
		String rev = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			rev = rev + s.charAt(i);
		}
		return rev;
	}
}
