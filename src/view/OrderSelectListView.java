package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.Order;

public class OrderSelectListView {

	private Scanner keyboard;

	public OrderSelectListView() {

		keyboard = new Scanner(System.in);
	}

	public void orderSelectList(ArrayList<Order> orderList) {

		System.out.println("\n주문 목록 보기\n");
		System.out.println("주문번호\t치킨메뉴\t가격\t주문수량");
		if (orderList.size() == 0) {
			new AlertView().alert("주문된 상품이 없습니다.");
		} else {
			for (int i = 0; i < orderList.size(); i++) {

				System.out.print(orderList.get(i).getUserOrderNumber() + "\t");
				System.out.print(orderList.get(i).getProductName() + "\t");
				System.out.print(orderList.get(i).getProductPrice() + "\t");
				System.out.println(orderList.get(i).getOrderAmount() + "\t");

			}
		}
		Controllers.getUserOrderController().requestOrderListMenu();
	}

	public void orderListMenu() {

		while (true) {
			System.out.println("1. 결제하기");
			System.out.println("2. 주문 수량 수정하기");
			System.out.println("3. 주문 삭제하기");
			System.out.println("4. 메인 메뉴 가기");

			int selectOrderListMenu = keyboard.nextInt();

			switch (selectOrderListMenu) {
			case 1:
				new AlertView().alert("결제 컨트롤러에 회원 결제를 요청했습니다.");
				Controllers.getPaymentController().requestUserRegister();
				break;
			case 2:
				new AlertView().alert("주문 컨트롤러에 주문 수량 수정을 요청했습니다.");
				Controllers.getUserOrderController().requestOrderUpdate();
				break;
			case 3:
				new AlertView().alert("주문 컨트롤러에 주문 삭제를 요청했습니다.");
				Controllers.getUserOrderController().requestOrderDelete();
				break;
			case 4:
				new AlertView().alert("제품 컨트롤러에 제품 목록을 요청함.");
				//Controllers.getProductController().requestSelectList();
				break;
			default:
				new AlertView().alert("메뉴를 다시 선택해주세요");
			}

		}
	}

}
