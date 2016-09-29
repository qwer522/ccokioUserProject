package view;

import java.util.Scanner;

import controller.Controllers;

public class CartUpdateView {

	private Scanner keyboard;

	public CartUpdateView() {

		keyboard = new Scanner(System.in);
	}

	public void updateOrderCount() {

		System.out.println("[*]  장     바      구     니      수     정 [*] ");
		System.out.println("[*] 장  바  구  니   수  정 번 호  입  력 [*] : ");
		int cartNumber = keyboard.nextInt();
		System.out.println("[*] 장  바  구  니   수  정 수 량  입  력 [*] : ");
		int updateOrderCount = keyboard.nextInt();

		Controllers.getCartController().requestUpdateOrderAmountProcess(cartNumber, updateOrderCount);
	}
	
	public void deleteCart() {
		System.out.println("[*]  장     바      구     니      삭     제   [*]");
		System.out.println("[*] 장  바  구  니    삭  제  수 량  입  력 [*]:");
		int cartNumber = keyboard.nextInt();
		
		Controllers.getCartController().requestCartDeleteOneProcess(cartNumber);
	}
}
