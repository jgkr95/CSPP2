import java.util.Scanner;

public class area_of_Circle {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float radius = scan.nextFloat();
		areaOfCircle(radius);
	}
	/*
	Need to fill the areaOfTriangle function and print the output
	of fahrenheit.
	*/
	public static void areaOfCircle(float r) {
		double area;
		area = 3.14 * r * r;
		System.out.println(area);
	}
}