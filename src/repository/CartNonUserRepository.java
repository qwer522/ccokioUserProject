package repository;

import java.util.ArrayList;

import domain.CartNonUser;

public class CartNonUserRepository {

	private static ArrayList<CartNonUser> CartNonUsers;
	private static int cartLastNumber;    //장바구니 번호 
	private static int productPriceSum;        //총 가격
	
	public CartNonUserRepository() {
		CartNonUsers = new ArrayList<CartNonUser>();
		productPriceSum = 0;
	}

	public static ArrayList<CartNonUser> getCartNonUsers() {
		return CartNonUsers;
	}

	public static void setCartNonUsers(ArrayList<CartNonUser> cartNonUsers) {
		CartNonUsers = cartNonUsers;
	}

	public static int getCartLastNumber() {
		return cartLastNumber;
	}

	public static void setCartLastNumber(int cartLastNumber) {
		CartNonUserRepository.cartLastNumber = cartLastNumber;
	}

	public static int getProductPriceSum() {
		return productPriceSum;
	}

	public static void setProductPriceSum(int productPriceSum) {
		CartNonUserRepository.productPriceSum = productPriceSum;
	}
	
}
