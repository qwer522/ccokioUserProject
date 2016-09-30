package domain;

public class NonUserPayment {

	private int paymentNumber;   //결제번호
	private String nonUserTel;   //전화번호
	private int orderNumber;     //주문번호
	private String productName;  //상품이름
	private int orderAmount;     //주문 수량
	private int proudctPrice;    //상품 가격
	private int orderSum;        //수량과 가격 곱한값
	private String paymentDate;  //날짜
	
	public NonUserPayment() {
		
	}

	public NonUserPayment(int orderNumber) {
		
		this.orderNumber = orderNumber;
		
	}

	public NonUserPayment(int paymentNumber, String nonUserTel, int orderNumber, String productName, int orderAmount,
			int proudctPrice, int orderSum, String paymentDate) {
		this.paymentNumber = paymentNumber;
		this.nonUserTel = nonUserTel;
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.orderAmount = orderAmount;
		this.proudctPrice = proudctPrice;
		this.orderSum = orderSum;
		this.paymentDate = paymentDate;
	}

	public int getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public String getNonUserTel() {
		return nonUserTel;
	}

	public void setNonUserTel(String nonUserTel) {
		this.nonUserTel = nonUserTel;
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

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getProudctPrice() {
		return proudctPrice;
	}

	public void setProudctPrice(int proudctPrice) {
		this.proudctPrice = proudctPrice;
	}

	public int getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(int orderSum) {
		this.orderSum = orderSum;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
