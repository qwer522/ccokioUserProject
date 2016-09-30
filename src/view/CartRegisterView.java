package view;

import java.util.Scanner;

public class CartRegisterView {

	private Scanner keyboard;
	
	public CartRegisterView() {
		
		keyboard = new Scanner(System.in);
	}

	//주문 수량 입력 화면 
	public int cartRegister() {

		int orderCount = 0;

		System.out.println("[*] 주문하실 수량을 입력해주세요 [*]");
		System.out.print(  "수  량  : ");

		orderCount = keyboard.nextInt();		

		return orderCount;

	}
}
