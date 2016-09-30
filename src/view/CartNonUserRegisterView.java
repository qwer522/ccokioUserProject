package view;

import java.util.Scanner;

import controller.Controllers;

public class CartNonUserRegisterView {

	private Scanner keyboard;

	public CartNonUserRegisterView() {
		keyboard = new Scanner(System.in);
	}

	public void cartNonUserRegister(int productNumber) {

		int orderCount = 0;

		System.out.println("[*] 주문하실 수량을 입력해주세요 [*]");
		System.out.print(  "수  량  : ");

		orderCount = keyboard.nextInt();	
		
		Controllers.getCartNonUserController().requestCartNonUserRegisterProccess(productNumber, orderCount);
	}
	
}
