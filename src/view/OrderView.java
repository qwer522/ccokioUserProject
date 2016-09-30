package view;

import java.util.Scanner;

import controller.Controllers;

public class OrderView {

	private Scanner keyboard;

	public OrderView() {

		keyboard = new Scanner(System.in);
	}

	public void orderUser() { //결제 또는 장바구니로

		System.out.println("1. 결제 ");
		System.out.println("2. 장바구니");

		int number = keyboard.nextInt();
		
		switch (number) {
		
		case 1:
			Controllers.getPaymentController().requestUserRegister();
			break;
		case 2:
			Controllers.getCartController().requestCartList();
			break;
		default:
			new AlertView().alert("[*] 메 뉴 를 다 시 선 택 해 주 세 요  [*]");
			
		}
		
	}
	
	public void orderNonUser() { //비회원 결제

		System.out.println("1. 결제 ");
		System.out.println("2. 장바구니");

		int number = keyboard.nextInt();
		
		switch (number) {
		
		case 1:
			Controllers.getPaymentController().requestNonUserRegister();
			break;
		case 2:
			
			break;
		default:
			new AlertView().alert("[*] 메 뉴 를 다 시 선 택 해 주 세 요  [*]");
			
		}
		
	}
	
}