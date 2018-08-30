import java.util.Scanner;
public class Average {
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
        System.out.println(average(a));
    }
    static float average(int[] a) {
        int sum = 0;
        for (int i=0; i<a.length; i++) {
            sum += a[i];
            // System.out.println("."+a[i]);

        }
        return sum/(float) a.length;

    }

}
