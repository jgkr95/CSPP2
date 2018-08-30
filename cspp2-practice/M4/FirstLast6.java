import java.util.Scanner;
public class FirstLast6 {
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();

        }
        System.out.println(firstLast6(a));
    }
    static boolean firstLast6(int[] a) {
        if (a[0] == 6 || a[a.length-1] == 6) {
            return true;
        }
        else {
            return false;
        }

    }

}
