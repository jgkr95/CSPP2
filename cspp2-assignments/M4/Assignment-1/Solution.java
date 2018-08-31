
import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }

    /**
     * { This is the main method in which we are finding max value
     *  from given array and prints  }.
     *
     * @param      args  The arguments are final
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        System.out.println(max);
    }
}
