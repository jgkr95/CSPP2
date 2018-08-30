import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /*
    Do not modify the main function 
    */
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
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
