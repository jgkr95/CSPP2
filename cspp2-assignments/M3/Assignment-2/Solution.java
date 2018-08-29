
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0, individualNumber = 0, n2 = 0;
        for (int i=0; i < n; i++) {
        	n2 = i;
        	while(n2 > 0) {
        	individualNumber = n2 % 10;
        	if (individualNumber == 7) {
        		count++;
        	}
        	n2 = n2 / 10;
        	}
        }
        System.out.println(count);
        
       
        
    }
}