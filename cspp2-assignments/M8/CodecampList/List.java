import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * List class implemented below.
 */
public class List {
    //Implement all the methods mentioned to build a ListADT

    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */

    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor
    private int[] a; 
    private int size;
    public static int hun, ten;

    /*
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     *
     */

    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor

    /*
     * The purpose of the constructor is to initialize the
     * class variables with some default values.
     */
    /**
     * Constructs the object.
     */
    public List() {

        // what are the two variables to be initialized here?
        // think about the private variables described above.
        // What should be the default values?
        // In the case of the list, it should be empty but
        // it should be initialized with an array size like 10
        ten = 10;
        hun = -100;
        a = new int[ten];
        for (int i = 0; i < a.length; i++) {
            a[i] = hun;
        }
        size = 0;

        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.

    }

    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     *
     * The method returns void (nothing)
     */
    /**
     * { In this fucntion we add the element to the array }.
     *
     * @param      item  The item is of integer type
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        int count = 0;
        try {
            for (int i = 0; a[i] != hun; i++) {
                count++;
            }
            a[count] = item;
        } catch (Exception e) {
            System.out.println("Invalid Position Exception");
        }
        // a[count] = item;
        // a[size] = item;
    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     */
    /**
     * { In this method we find the size of the array i.e no of valid elements}.
     *
     * @return     { Size of the array }
     */
    public int size() {
        // replace the code below to implement the size method
        int i;
        size = 0;
        for (i = 0; a[i] != hun; i++) {
            size++;
        }
        return size;
    }

    /*
     * The remove method does what the name suggests.
     * Removes an int item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(2) would remove the item 2
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like this.
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */
    /**
     * { In this method we remove element from the given index}.
     *
     * @param      index  The index is of integer type
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        // a[index] = a[index+1];
        // a[index+1]=0
        int i = 0;
        try {
            for (i = index; a[i] != hun; i++) {
                a[i] = a[i + 1];
            }
            a[i] = hun;
        } catch (Exception e) {
            System.out.println("Invalid Position Exception");
        }
    }

    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */
    /**
     * { In this method we give element present at the given index }.
     *
     * @param      index  The index is of integer type
     *
     * @return     { integer type is returned either element or -1}
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (a[index] != hun) {
            return a[index];
        } else if (index > size) {
            return -1;
        }
        return -1;
    }

    /*
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     */
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        int i, con = 0;
        String strofarray = "[";
        for (i = 0; a[i] != hun; i++) {
            con++;
        }
        int s = con;
        int[] copyarray = new int[i];
        for (i = 0; a[i] != hun; i++) {
            copyarray[i] = a[i];
            strofarray += a[i];
            if (i < s - 1) {
                strofarray += ',';
            }
        }
        strofarray += ']';
        // System.out.println(copyarray.toString());
        return strofarray;
    }

    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */
    /**
     * { Checks if the item presents in array or not}.
     *
     * @param      item  The item is of integer type
     *
     * @return     { retuns true if item present in array else false }
     */
    public boolean contains(final int item) {
        // Replace the code below
        for (int i = 0; i < a.length; i++) {
            if (item == a[i]) {
                return true;
            }
        }
        return false;
    }

    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    /**
     * Searches for the first match.
     *
     * @param      item  The item is of integer type
     *
     * @return     { Returns index of the given element }
     */
    public int indexOf(final int item) {
        // Replace the code below
        try {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == item) {
                    return i;
                }
            }
        } catch (Exception e) {
            System.out.println("Index Out of Bounds Exception");
        }
        return -1;
    }
    /**
     * { This is main method}.
     *
     * @param      args  The arguments of string type.
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "add":
                l.add(Integer.parseInt(tokens[1]));
                break;
            case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
            case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
            case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
            case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
            case "get":
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
            case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
            }
        }
    }
}
