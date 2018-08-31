import java.util.Scanner;
public class Concatinate {
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(concatinate(str));
    }
    static String concatinate(String a) {
        return "Hello "+ a +"!";

    }

}
