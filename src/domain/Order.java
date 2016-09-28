package domain;

public class Order {

	private int UserOrderNumber;
	private String userId;
	private String productName;
	private int orderAmount;
	private int productPrice;
	private String userAddress;
	
	
	public Order() {
		
	}
	
	public Order(int userOrderNumber, String userId, String productName, 
			int orderAmount, int productPrice, String userAddress) {
		
		this.UserOrderNumber = userOrderNumber;
		this.userId = userId;
		this.productName = productName;
		this.orderAmount = orderAmount;
		this.productPrice = productPrice;
		this.userAddress = userAddress;
		
	}

	

	public int getUserOrderNumber() {
		return UserOrderNumber;
	}

	public void setUserOrderNumber(int userOrderNumber) {
		UserOrderNumber = userOrderNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}
