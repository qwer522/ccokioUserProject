package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controllers;

public class CartUserRegisterView {

	private Scanner keyboard;
	
	public CartUserRegisterView() {
		
		keyboard = new Scanner(System.in);
	}

	//주문 수량 입력 화면 
	public int cartRegister(int productNumber) {

		int orderCount = 0;

		try {
			System.out.println("[*] 주문하실 수량을 입력해주세요 [*]");
			System.out.print(  "수  량  : ");

			orderCount = keyboard.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("올바른 입력을 입력해주세요.");
			Controllers.getCartController().requestCartRegister(productNumber);
		}
				

		return orderCount;

	}
}
