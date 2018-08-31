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
     * { this is main method and it reads inputs for finiding quadratic equation }
     *
     * @param      args  The arguments are final here
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadrati(a, b, c);
    }
    /**
     * { This is the method for finding the roots of the quadratic equation }.
     *
     * @param      a     { integer type varible }
     * @param      b     { integer type varible }
     * @param      c     { integer type variable }
     */
    public static void rootsOfQuadrati(final int a, final int b, final int c) {
        final int i = 4, j = 2;
        double r1 = (-b - Math.sqrt((b * b) - (i * a * c))) / (j * a);
        double r2 = (-b + Math.sqrt((b * b) - (i * a * c))) / (j * a);
        System.out.println(r2 + " " + r1);
        // System.out.println(r2);
    }
}
