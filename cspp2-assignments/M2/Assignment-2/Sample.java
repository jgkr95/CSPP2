/**
    * Describe about the class.
    * Author: Gandhi
    * Date: 28/08/2018 3:00pm
*/

class Square {
    /**
        * This method finds out the square of the given input.
        * @param x x value which is used to find the square.
        * @return int: returns the square of x.
    */
    public int square(final int x) {
        x = x + 1;
        System.out.println(x);
    }
}


/**
*/
public final class Sample {

    /**
        * Describe about the constructor.
    */
    private Sample() {

    }
    /**
        * Describe about the main method.
        * @param args The command line args will be stored.
        * @return int: Returns an integer value.
    */
    public static int main(final String[] args) {
        System.out.println(args[1]);
        // System.out.println(square(a));
        final int a = 10;
        Square sq = new Square();
    }
}

