package domain;

public class UserPayment {

	private int paymentNumber;
	private String userId;
	private int orderNumber;
	private String productName;
	private int orderAmount;
	private int orderSum;
	private String paymentDate;
	
	public UserPayment() {
		
	}

	public UserPayment(int orderNumber) {
		
		this.orderNumber = orderNumber;
		
	}

	public UserPayment(int paymentNumber, String userId, int orderNumber,  String productName, int orderAmount, int orderSum, String paymentDate) {
		
		this.paymentNumber = paymentNumber;
		this.userId = userId;
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.orderAmount = orderAmount;
		this.orderSum = orderSum;
		this.paymentDate = paymentDate;
		
	}

	public int getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(int orderSum) {
		this.orderSum = orderSum;
	}

	public int getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getOrderCount() {
		return orderAmount;
	}

	public void setOrderCount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	
}
