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
     * { This is main function}.
     *
     * @param      args  The arguments are final here
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * { This is the fucntion to reverse the string}.
     *
     * @param      s     { s is string type of varible}
     *
     * @return     { reverse of the string retuned }
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
