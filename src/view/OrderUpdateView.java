package view;

import java.util.Scanner;

import controller.Controllers;

public class OrderUpdateView {

	private Scanner keyboard;

	public OrderUpdateView() {

		keyboard = new Scanner(System.in);
	}

	public void selectOrderUpdateNumber() {
		
		System.out.println("수정할 주문의 주문 번호를 입력해주세요");
		System.out.print("주문 번호 : ");
		int selectOrderNumber = keyboard.nextInt();

		System.out.println("수정 수량 : ");
		int updateOrderAmount = keyboard.nextInt();

		Controllers.getUserOrderController().requestorderUpdateProsess(selectOrderNumber, updateOrderAmount);
	}
}
