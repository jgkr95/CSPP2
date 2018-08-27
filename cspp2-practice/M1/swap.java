import java.util.Scanner;
public class swap {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a,b;
		System.out.println("Enter two numbers: ");
		a = s.nextInt();
		b = s.nextInt();
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("The numbers after swapping are ");
		System.out.println(a);
		System.out.println(b);
	}
}