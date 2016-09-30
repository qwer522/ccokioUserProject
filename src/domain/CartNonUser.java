package domain;

public class CartNonUser {

	private int cartNumber;      //장바구니 번호
	private String productName;  //상품 이름 
	private int orderAmount;     //상품 수량
	private int productPrice;    //상품가격
	private int productPriceSum; //상품 합계
	
	public CartNonUser() {
		
	}

	public CartNonUser(int cartNumber, String productName, int orderAmount, int productPrice, int productPriceSum) {
		this.cartNumber = cartNumber;
		this.productName = productName;
		this.orderAmount = orderAmount;
		this.productPrice = productPrice;
		this.productPriceSum = productPriceSum;
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

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductPriceSum() {
		return productPriceSum;
	}

	public void setProductPriceSum(int productPriceSum) {
		this.productPriceSum = productPriceSum;
	}

}
