import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
    * size integer varibale.
    */
    private int size;
    /**
     * { set integer array }.
     */
    private int[] set;
    /**
     * Constructs the object.
     */
    Set() {
        size = 0;
        final int twenty = 20;
        set = new int[twenty];
    }
    /**
     * { gives size }.
     *
     * @return     { integer value is returned }
     */
    public int size() {
        return size;
    }
    /**
     * { reisez the set }.
     */
    public void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }
    /**
     * { gives whether item present in set or not }.
     *
     * @param      item  The item is of integer type.
     *
     * @return     { true or false depending on whether present or not }
     */
    public boolean contains(final int item) {
        for (int i = 0; i < set.length; i++) {
            if (item == (set[i])) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "{";
        for (int i = 0; i < size; i++) {
            str += set[i];
            if (i < size - 1) {
                str += ", ";
            }
        }
        str += "}";
        return str;
    }
    /**
     * { adds the element to the set }.
     *
     * @param      item  The item is of integer type
     */
    public void add(final int item) {
        if (size == set.length) {
            resize();
        }
        if (!contains(item)) {
            set[size++] = item;
        }
    }
    /**
     * { adds the array of ellements }.
     *
     * @param      newset  The newset is of array integer type
     */
    public void add(final int[] newset) {
        for (int i = 0; i < newset.length; i++) {
            add(newset[i]);
        }
    }
    /**
     * { Gives the common elements }.
     *
     * @param      t     { t is claas object }
     *
     * @return     { class Set object is returned }
     */
    public Set intersection(final Set t) {
        Set newobject = new Set();
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j < t.size; j++) {
                if (t.set[j] == set[i]) {
                    newobject.add(set[i]);
                }

            }
        }
        return newobject;
    }
    /**
     * { Gives the elements present in set array if they are in given array }.
     *
     * @param      s     { s is of integer array tyep }
     *
     * @return     { class object is returned }
     */
    public Set retainAll(final int[] s) {
        Set newobj = new Set();
        for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] == (set[i])) {
                    newobj.add(set[i]);
                }

            }
        }
        return newobj;
    }
    /**
     * { Gives the cartesian prouct of the sets }.
     *
     * @param      t     { t is class object }
     *
     * @return     { integer array is returned }
     */
    public int[][] cartesianProduct(final Set t) {
        int si = size * t.size;
        int[][] cp = new int[si][2];
        if (size == 0 || t.size == 0) {
            return null;
        }

        for (int i = 0, k = 0; i < size; i++) {
            for (int j = 0; j < t.size; j++, k++) {
                cp[k][0] = set[i];
                cp[k][1] = t.set[j];

            }

        }
        return cp;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation
            // invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(
                    s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(
                    Arrays.deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
