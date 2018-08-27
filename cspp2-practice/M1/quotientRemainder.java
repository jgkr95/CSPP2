import java.util.Scanner;
public class quotientRemainder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a, b, quotient, remainder;
		System.out.println("Enter two numbers: ");
		a = s.nextInt();
		b = s.nextInt();
		quotient = a/b;
		remainder = a%b;
		System.out.println("The quotient = "+quotient);
		System.out.println("The remainder = "+remainder);
	}
}