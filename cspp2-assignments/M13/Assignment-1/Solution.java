import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
	//your code goes here...
	//Good luck :-)
	private int size;
	private int[] set;
	/**
	 * Constructs the object.
	 */
	Set() {
		size = 0;
		set = new int[20];
	}
	public int size() {
		return size;
	}
	public void resize() {
		set = Arrays.copyOf(set, 2 * size);
	}
	public boolean contains(int item) {
		for (int i = 0; i < set.length; i++) {
			if (item == (set[i])) {
				return true;
			}
		}
		return false;
	}
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
	public void add(int item) {
		if (size == set.length) {
			resize();
		}
		if (!contains(item)) {
			set[size++] = item;
		}
	}
	public void add(int[] newset) {
		for (int i = 0; i < newset.length; i++) {
			add(newset[i]);
		}
	}
	public Set intersection(Set s) {
		Set newobject = new Set();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < s.set.length; j++) {
				if (s.set[i] == (set[i])) {
					newobject.add(set[i]);
				}

			}
		}
		return newobject;
	}
	public Set retainAll(int[] s) {
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
	public int[][] cartesianProduct(Set t) {
		int[][] cp=new int[size()*t.size()][2];
		if(size==0) {
			return null;
		}
		for(int i=0;i<size;i++) {
			for (int j=0;j<t.size();j++) {
				cp[i][0]=set[i];
				cp[i][1]=t.set[j];
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
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "size":
				System.out.println(s.size());
				break;
			case "contains":
				System.out.println(s.contains(Integer.parseInt(tokens[1])));
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
				System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
				break;
			default:
				break;
			}
		}
	}
}
