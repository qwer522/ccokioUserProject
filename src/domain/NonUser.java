package domain;

public class NonUser {

	// private int nonUserNumber;
	private String nonUserName;
	private String nonUserTel;

	public NonUser() {

	}

	public NonUser(String nonUserName, String nonUserTel) {
		this.nonUserName = nonUserName;
		this.nonUserTel = nonUserTel;
	}

	// public int getNonUserNumber() {
	// return nonUserNumber;
	// }
	//
	// public void setNonUserNumber(int nonUserNumber) {
	// this.nonUserNumber = nonUserNumber;
	// }

	public String getNonUserName() {
		return nonUserName;
	}

	public void setNonUserName(String nonUserName) {
		this.nonUserName = nonUserName;
	}

	public String getNonUserTel() {
		return nonUserTel;
	}

	public void setNonUserTel(String nonUserTel) {
		this.nonUserTel = nonUserTel;
	}

}
