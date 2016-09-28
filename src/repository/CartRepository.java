package repository;

import java.util.ArrayList;

import domain.Cart;

public class CartRepository {

	private static ArrayList<Cart> cart;
	private static int cartNumber;
	
	public CartRepository() {
		
		cart = new ArrayList<Cart>();
		cartNumber = 0;
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
