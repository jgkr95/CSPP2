import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
	/*Write the atrributes and methods for InputValidator*/
	private String data;
	/**
	 * Constructs the object.
	 *
	 * @param      string  The string is the input given by the user
	 */
	InputValidator(String string) {
		data = string;
	}
	boolean validateData() {
		final int six = 6;
		if (data.length() < six) {
			return false;
		}
		return true;
	}
}
/**
 * { Class Solution takes input and prints false if length of name less than 6 else true}
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() { }
	/**
	 * { This is main function to read the input}.
	 * @param args {args of type String}
	 */
	public static void main(final String args[])
    {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);
    	System.out.println(i.validateData());

    }

}
