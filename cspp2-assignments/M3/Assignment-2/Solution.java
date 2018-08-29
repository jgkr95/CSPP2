
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    /**
     * Constructs the object.
     */
    private Solution() {}
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        /**
         * { var_description }.
         */
        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0, individualNumber = 0, n2 = 0;
        final int ten = 10, seven = 7;
        for (int i=0; i < n; i++) {
            n2 = i;
            while(n2 > 0) {
            individualNumber = n2 % ten;
            if (individualNumber == seven) {
                count++;
            }
            n2 = n2 / ten;
            }
        }
        System.out.println(count);    
    }
}