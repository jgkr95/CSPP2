import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
    private Solution() {
    /**
     * { item_description }.
     */
    }
    /**
        * @param args Do not modify this main function.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadrati(a, b, c);
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      c     { parameter_description }
     */
    public static void rootsOfQuadrati(final int a, final int b, final int c) {
        final int i = 4, j = 2;
        double r1 = (-b - Math.sqrt((b * b) - (i * a * c))) / (j * a);
        double r2 = (-b + Math.sqrt((b * b) - (i * a * c))) / (j * a);
        System.out.println(r2 + " " + r1);
        // System.out.println(r2);
    }
}
