
// Given an String, Write a java method that returns the
//decimal value for the given binary string.
import java.util.Scanner;
/**
 * Class for solution. // Given an String, Write a java method that returns the
 * decimal value for the given binary string.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { This is main function}.
     *
     * @param      args  The arguments are final
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            // System.out.println("HELLO");
            String s = sc.nextLine();
            // System.out.println(s + "HI");
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }

    /**
     * { This is the fucntioin where string of binary will be converted to decimal and returns the value}.
     *
     * @param      a     { string of binary number }
     *
     * @return     { string(int) is returned }
     */
    public static String binaryToDecimal(final String a) {
        int count = 0;
        long b = Long.parseLong(a);
        long indi = 0;
        double num = 0;
        final int ten = 10;
        while (b > 0) {
            indi = b % ten;
            count++;
            num += indi * Math.pow(2, count - 1);
            b = b / ten;
        }
        int num1 = (int) num;
        return String.valueOf(num1);
    }


}

