package repository;

import java.util.ArrayList;

import domain.Cart;

public class CartRepository {

	private static ArrayList<Cart> cart;
	private static int cartNumber;   //장바구니 번호 
	private static int coupon;       //쿠폰
	private static String userClass; //회원 등급
	private static double totalPrice;//총 가격

	public CartRepository() {

		cart = new ArrayList<Cart>();
		cartNumber = 0;
	}

	public static double getTotalPrice() {
		return totalPrice;
	}

	public static void setTotalPrice(double tatolPrice) {
		CartRepository.totalPrice = tatolPrice;
	}

	public static String getUserClass() {
		return userClass;
	}

	public static void setUserClass(String userClass) {
		CartRepository.userClass = userClass;
	}

	public static int getCoupon() {
		return coupon;
	}

	public static void setCoupon(int coupon) {
		CartRepository.coupon = coupon;
	}

	public static ArrayList<Cart> getCart() {
		return cart;
	}

	public static void setCart(ArrayList<Cart> cart) {
		CartRepository.cart = cart;
	}

	public static int getCartNumber() {
		return cartNumber;
	}

	public static void setCartNumber(int cartNumber) {
		CartRepository.cartNumber = cartNumber;
	}

}
