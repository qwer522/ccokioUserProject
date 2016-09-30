package domain;

public class Product {

	private int productNumber;
	private String productName;
	private String productCommant;
	private int productPrice;
	private String productOrigin;

	public Product() {

	}

	public Product(String productName, String productCommant, int productPrice, String productOrigin) {

		this.productName = productName;
		this.productCommant = productCommant;
		this.productPrice = productPrice;
		this.productOrigin = productOrigin;
	}

	public int getProductNumber() {

		return productNumber;

	}

	public void setProductNumber(int productNumber) {

		this.productNumber = productNumber;

	}

	public String getProductName() {

		return productName;

	}

	public void setProductName(String productName) {

		this.productName = productName;

	}

	public String getProductCommant() {

		return productCommant;

	}

	public void setProductCommant(String productCommant) {

		this.productCommant = productCommant;

	}

	public int getProductPrice() {

		return productPrice;

	}

	public void setProductPrice(int productPrice) {

		this.productPrice = productPrice;

	}

	public String getProductOrigin() {

		return productOrigin;

	}

	public void setProductOrigin(String productOrigin) {

		this.productOrigin = productOrigin;

	}

}
