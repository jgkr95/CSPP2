import java.util.Scanner;
public class Concatinate {
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(helloName(str));
    }
    static String helloName(String a) {
        return "Hello "+ a +"!";

    }

}
