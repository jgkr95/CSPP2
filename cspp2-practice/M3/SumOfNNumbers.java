import java.util.Scanner;

public class SumOfNNumbers {
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0,n = scan.nextInt();
        for (int i = 1; i <= n; i++ ) {
            sum += i;
        }
        System.out.println(sum);


    }


}
