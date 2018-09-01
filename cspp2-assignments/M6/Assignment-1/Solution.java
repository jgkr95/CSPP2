import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
    // write your code here
        int count = 0;
        final int two = 2, three = 3;
        for (int i = two; i < n; i++) {
            if (i % two == 1) {
                count = 0;
                int m = i;
                for (int j = three; j < m; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                }
                if (count != 0) {
                    System.out.println(i);
                    }
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

