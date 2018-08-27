import java.util.Scanner;
public class degrees_to_fahrenheit {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a;
		double b;
		System.out.println("Enter the temperature in degrees : ");
		a = s.nextInt();
		b = (a * 1.8)+32;

		System.out.println("The equivalent temperature in farenheit is  "+b);
	}
}