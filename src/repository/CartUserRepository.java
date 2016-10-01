package repository;

import java.util.ArrayList;

import domain.CartUser;

public class CartUserRepository {

	private static ArrayList<CartUser> cart;
	private static int cartNumber;   //장바구니 번호 
	private static int coupon;       //쿠폰
	private static String userClass; //회원 등급
	private static double totalPrice;//총 가격

	public CartUserRepository() {

		cart = new ArrayList<CartUser>();
		cartNumber = 0;
		coupon = 0;
		userClass = null;
		totalPrice = 0;
	}

	public static double getTotalPrice() {
		return totalPrice;
	}

	public static void setTotalPrice(double tatolPrice) {
		CartUserRepository.totalPrice = tatolPrice;
	}

	public static String getUserClass() {
		return userClass;
	}

	public static void setUserClass(String userClass) {
		CartUserRepository.userClass = userClass;
	}

	public static int getCoupon() {
		return coupon;
	}

	public static void setCoupon(int coupon) {
		CartUserRepository.coupon = coupon;
	}

	public static ArrayList<CartUser> getCart() {
		return cart;
	}

	public static void setCart(ArrayList<CartUser> cart) {
		CartUserRepository.cart = cart;
	}

	public static int getCartNumber() {
		return cartNumber;
	}

	public static void setCartNumber(int cartNumber) {
		CartUserRepository.cartNumber = cartNumber;
	}

}
