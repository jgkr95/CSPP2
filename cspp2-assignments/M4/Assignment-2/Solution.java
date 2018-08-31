import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /* Fill the main function to print resultant of addition of matrices*/
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { This is main method in which matrices are taken as input 
     *  and add them if they are compatible}.
     *
     * @param      args  The arguments are final
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] a = new int[m][n];
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
            }
        }
        int p = s.nextInt();
        int q = s.nextInt();
        int[][] b = new int[m][n];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                b[i][j] = s.nextInt();
            }
        }
        if (m == p && n == q) {
            for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j]);
                if (j < q - 1) {
                System.out.print(" ");
                }
            }
            System.out.println();
            }
        } else {
            System.out.println("not possible");
        }
    }
}
