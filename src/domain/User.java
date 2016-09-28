package domain;

public class User {
	
	private int userNumber;
	private String userId;
	private String userPassword;
	private String userName;
	private String userTel;
	private String userAddress;
	private String purchaseQuantity;
	
	
	public User() {

	}
	// 회원 정보 수정시 사용될 필드
	public User(String userPassword, String userTel, String userAddress) {

		
		this.userPassword = userPassword;
		this.userTel = userTel;
		this.userAddress = userAddress;
	}

	

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(String purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	
	
	

}
