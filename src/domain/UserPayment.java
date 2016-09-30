package domain;

public class UserPayment {

	private int paymentNumber;   //결제번호
	private String userId;       //회원ID
	private String userClass;    //회원등급
	private int orderNumber;     //주문번호
	private String productName;  //상품이름
	private int orderAmount;     //주문 수량
	private int couponuseAmount; //사용된 쿠폰
	private int productPrice;    //상품가격
	private String paymentDate;  //주문 날짜
	private double orderSum;     //수량과 가격 곱한값
	
	
	public UserPayment() {
		
	}

	public UserPayment(int orderNumber) {
		
		this.orderNumber = orderNumber;
		
	}

	

	public UserPayment(int paymentNumber, String userId, String userClass, int orderNumber, String productName,
			int orderAmount, int couponuseAmount, int productPrice, String paymentDate, double orderSum) {
		this.paymentNumber = paymentNumber;
		this.userId = userId;
		this.userClass = userClass;
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.orderAmount = orderAmount;
		this.couponuseAmount = couponuseAmount;
		this.productPrice = productPrice;
		this.paymentDate = paymentDate;
		this.orderSum = orderSum;
	}

	public int getCouponuseAmount() {
		return couponuseAmount;
	}

	public void setCouponuseAmount(int couponuseAmount) {
		this.couponuseAmount = couponuseAmount;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getUserClass() {
		return userClass;
	}

	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public double getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(double orderSum) {
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
