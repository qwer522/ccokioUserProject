package view;

import java.util.Scanner;

import controller.Controllers;

public class CartUpdateView {

	private Scanner keyboard;

	public CartUpdateView() {

		keyboard = new Scanner(System.in);
	}

	public void updateOrderCount() {

		System.out.println("[*]  수량 수정    [*] ");
		System.out.print("장바구니 번호 : ");
		int cartNumber = keyboard.nextInt();
		System.out.print("수  량 : ");
		int updateOrderCount = keyboard.nextInt();

		Controllers.getCartController().requestUpdateOrderAmountProcess(cartNumber, updateOrderCount);
	}
	
	public void deleteCart() {
		System.out.println("[*]  장 바 구 니   상 품   삭 제   [*]");
		System.out.print("장바구니 번호 : ");
		int cartNumber = keyboard.nextInt();
		
		Controllers.getCartController().requestCartDeleteOneProcess(cartNumber);
	}
}
