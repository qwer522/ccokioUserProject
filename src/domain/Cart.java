package domain;

public class Cart {

	private int cartNumber;
	private String productName;
	private int orderAmount;
	private int productPrice;
	
	public Cart() {
		
	}
	
	public Cart(int cartNumber, String productName, int orderAmount, int productPrice) {
		
		this.cartNumber = cartNumber;
		this.productName = productName;
		this.orderAmount = orderAmount;
		this.productPrice = productPrice;
		
	}

	public int getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	
}
