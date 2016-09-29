package view;

import java.util.Scanner;

import controller.Controllers;

public class OrderDeleteView {

	private Scanner keyboard;

	public OrderDeleteView() {

		keyboard = new Scanner(System.in);
	}

	public void selectOrderDeleteNumber() {

		System.out.println("취소를 할 주문의 주문 번호를 입력해주세요");
		System.out.print("주문 번호 : ");
		int selectOrderNumber = keyboard.nextInt();

		while (true) {
			System.out.println("정말로 취소하시겠습니까?");
			System.out.println("1. 주문 취소/t2. 주문목록으로");
			int selectConfirm = keyboard.nextInt();

			switch (selectConfirm) {
			case 1:
				Controllers.getUserOrderController().requestOrderDeleteProsess(selectOrderNumber);
				break;
			case 2:
				Controllers.getUserOrderController().requestOrderList();
				break;
			default:
				new AlertView().alert("다시 선택해주세요.");
			}
		}
	}
}
