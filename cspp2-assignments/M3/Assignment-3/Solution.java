
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcdo;
        gcdo = gcd(n1, n2);
        System.out.println(gcdo);
    }
    /*
	Need to write the gcd function and print the output.
	*/
    public static int gcd(int a, int b) {
        int[] c;
        int j = 0;
        c = new int[Math.max(a, b)];
        for (int i = 1; i < Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                c[j] = i;
                // System.out.println(j);
                j++;
            }
        }
        return c[j-1];
    }
}
