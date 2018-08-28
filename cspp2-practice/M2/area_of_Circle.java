import java.util.Scanner;

public class area_of_Circle {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float radius = scan.nextFloat();
		System.out.println(area(radius));
		// area(radius);
	}
	/*
	Need to fill the areaOfTriangle function and print the output
	of fahrenheit.
	*/
	public static double pi()
	{
		return 3.14;
	}
	public static double area(float r) {
		double area;
		area = pi() * r * r;
		// System.out.println(area);
		return area;
	}
}