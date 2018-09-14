import java.util.*;
class Item {
	private String productname;
	private int quantity;
	private double price;
	Item(String productname, int quantity, double price) {
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
	}
	Item(String productname, int quantity) {
		this.productname = productname;
		this.quantity = quantity;
	}
	public String getproductname() {
		return productname;
	}
	public int getquantity() {
		return quantity;
	}
	public double getprice() {
		return price;
	}
	public void removeitemsquantity(Item item) {
		quantity = quantity - item.getquantity();
		// System.out.println(quantity);
	}
	public void setquantity(int quantity) {
		this.quantity += quantity;
	}

	public String toString() {
		return this.productname;
	}
}
class Shoppingcart {
	private Item[] product;
	private int itemcount;
	private Item[] cart;
	private int cartcount;
	private	double totalamount = 0;
	private double payableamount = 0;
	private	double couponn;
	private double tax = 0;
	private double discount = 0;

	Shoppingcart() {
		product = new Item[10];
		cart = new Item[10];
		itemcount = 0;
		cartcount = 0;
		couponn = 0;

	}
	public void addToCatalog(Item item) {
		product[itemcount++] = item;

	}
	public void addToCart(Item item) {
		int flag = 0;
		for (int i = 0; i < cartcount; i++) {
			if (cart[i].getproductname().equals(item.getproductname())) {
				flag = 1;
				cart[i].setquantity(item.getquantity());

			}
		}

		if (flag == 0) {
			cart[cartcount++] = item;
		}
	}
	public void removeFromCart(Item item) {
		int flag = 0;
		int position=0;
		for (int i = 0; i < cartcount; i++) {
			if (item.getproductname().equals(cart[i].getproductname())) {
				cart[i].removeitemsquantity(item);
				if(cart[i].getquantity()==0) {
					flag = 1;
					position=i;
				}
				break;
			}
		}
		if(flag!=0) {
		for(int i=position;i<cartcount;i++) {
			cart[i]=cart[i+1];
			}
		
		cart[cartcount-1]=null;
		cartcount--;
		}
		

	}
	public void showcart() {
		for (int i = 0; i < cartcount; i++) {
			if(cart[i].getquantity()!=0) {
				System.out.println(cart[i].getproductname() + " " + cart[i].getquantity());
			}
		}

	}
	public void showcartwithprice() {
		for (int i = 0; i < cartcount; i++) {
			for (int j = 0; j < itemcount; j++) {
				if (cart[i].getproductname().equals(product[j].getproductname())) {
					if(cart[i].getquantity()!=0) {
					System.out.println(cart[i].getproductname() + " " + cart[i].getquantity() + " " + product[j].getprice());
				}
			}
			}
		}
	}
	public void showCatalog() {
		for (int i = 0; i < itemcount; i++) {
			System.out.println(product[i].getproductname() + " " + product[i].getquantity() + " " + product[i].getprice());
		}

	}
	public double getTotalAmount() {
		// System.out.println(Arrays.toString(cart));
		totalamount = 0;
		for (int i = 0; i < cartcount; i++) {
			for (int j = 0; j < itemcount; j++) {
				if (cart[i].getproductname().equals(product[j].getproductname())) {
					totalamount += cart[i].getquantity() * product[j].getprice();
				}
			}
		}
		// totalamount = totalamount - discount;
		// System.out.println("totalAmount: " + totalamount);
		return totalamount;
	}
	public double getPayableAmount() {
		payableamount = getTotalAmount()  - getTotalAmount() * couponn;
		tax = payableamount * 0.15;
		// payableamount = payableamount - discount;
		payableamount *= 1.15;
		// System.out.println("Payable amount: " + payableamount);
		return payableamount;
	}
	public void applyCoupon(String coupon) {
		if (couponn == 0.0) {
			discount = 0;
			if (coupon.equals("IND10")) {
				// totalamount = totalamount - totalamount * 0.1;
				couponn = 0.1;
				discount = totalamount * 0.1;
			} else if (coupon.equals("IND20")) {
				// totalamount = totalamount - totalamount * 0.2;
				couponn = 0.2;
				discount = totalamount * 0.2;
			} else if (coupon.equals("IND30")) {
				// totalamount = totalamount - totalamount * 0.3;
				couponn = 0.3;
				discount = totalamount * 0.3;

			} else if (coupon.equals("IND50")) {
				// totalamount = totalamount - totalamount * 0.5;
				couponn = 0.5;
				discount = totalamount * 0.5;
				// System.out.println(discount + "GANDHI");
			} else {
				System.out.println("Invalid coupon");
			}
		}

	}
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		showcartwithprice();
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + couponn * getTotalAmount());
		System.out.println("Tax:" + tax);
		// getPayableAmount();
		System.out.println("Payable amount: "+Math.round(getPayableAmount()*10)/10.0);
	}
}
