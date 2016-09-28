package view;

import java.util.Scanner;

import controller.Controllers;

public class CartUpdateView {

	private Scanner keyboard;

	public CartUpdateView() {

		keyboard = new Scanner(System.in);
	}

	public void updateOrderCount() {

		System.out.println("수량 변경할 장바구니 번호를 입력해주세요.");
		System.out.println("장바구니 번호 : ");
		int cartNumber = keyboard.nextInt();
		System.out.println("수정 수량 : ");
		int updateOrderCount = keyboard.nextInt();

		Controllers.getCartController().requestUpdateOrderAmountProcess(cartNumber, updateOrderCount);
	}
	
	public void deleteCart() {
		
		System.out.println("삭제할 장바구니 번호를 입력해주세요");
		System.out.println("장바구니 번호 : ");
		int cartNumber = keyboard.nextInt();
		
		Controllers.getCartController().requestCartDeleteOneProcess(cartNumber);
	}
}
