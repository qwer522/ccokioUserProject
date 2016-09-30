package view;

import java.util.Scanner;

import controller.Controllers;

public class CartNonUserUpdateView {

	private Scanner keyboard;

	public CartNonUserUpdateView() {

		keyboard = new Scanner(System.in);
	}

	public void nonUserUpdateOrderCount() {

		System.out.println("[*]  수량 수정    [*] ");
		System.out.print("장바구니 번호 : ");
		int cartNumber = keyboard.nextInt();
		System.out.print("수  량 : ");
		int updateOrderCount = keyboard.nextInt();

		Controllers.getCartNonUserController().requestNonUserUpdateOrderAmountProcess(cartNumber, updateOrderCount);
	}
	
	public void nonUserDeleteCart() {
		System.out.println("[*]  장 바 구 니   상 품   삭 제   [*]");
		System.out.print("장바구니 번호 : ");
		int cartNumber = keyboard.nextInt();
		
		Controllers.getCartNonUserController().requestCartNonUserDeleteOneProcess(cartNumber);
	}
}
