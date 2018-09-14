import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // BookYourShow bys = new BookYourShow();
        Shoppingcart shop = new Shoppingcart();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        final int ten = 10;
        final double tenn = 10.0;
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().split(" ");
            // String[] check = tokens[1].split(",");
            switch (tokens[0]) {
            case "Item":
                String[] dataa = tokens[1].split(",");
                shop.addToCatalog(new Item(dataa[0],
                Integer.parseInt(dataa[1]), Double.parseDouble(dataa[2])));
                break;

            case "add":
                String[] dat = tokens[1].split(",");
                shop.addToCart(new Item(dat[0], Integer.parseInt(dat[1])));
                break;

            case "remove":
                String[] data = tokens[1].split(",");
                shop.removeFromCart(new Item(data[0],
                                             Integer.parseInt(data[1])));
                break;
            case "show":
                shop.showcart();
                break;
            case "catalog":
                shop.showCatalog();
                break;
            case "totalAmount":
                // shop.getTotalAmount();
                System.out.println("totalAmount: " + shop.getTotalAmount());
                break;
            case "payableAmount":
                // shop.getPayableAmount();
                System.out.println("Payable amount: "
                 + Math.round(shop.getPayableAmount() * ten) / tenn);
                break;
            case "coupon":
                shop.applyCoupon(tokens[1]);
                // System.out.println(tokens[0]);
                break;
            case "print":
                shop.printInvoice();
                break;
            default:
                break;
            }
        }
    }
}
