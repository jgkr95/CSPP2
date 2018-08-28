import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { var_description }.
     */
    private Solution() {
        /**
         * { item_description }.
         */
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
     * { function_description }.
     *
     * @param      b     { parameter_description }
     * @param      e     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static long power(final int b, final int e) {
        /**
         * { item_description }.
         */
        if (e == 0) {
            return 1;
        }
        return b * power(b, e - 1);
    }
}
