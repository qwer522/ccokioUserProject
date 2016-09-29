package view;

import java.util.Scanner;

import controller.Controllers;

public class CheckUserOrder {

	private Scanner keyboard;
	
	public CheckUserOrder() {
		
		keyboard = new Scanner(System.in);
	}
	
	public void checkUserOrder() {
		
		System.out.println("1. 회원 주문내역 보기");
		System.out.println("2. 비회원 주문내역 보기");
		int selectCheckUserOrder = keyboard.nextInt();
		
		if (selectCheckUserOrder == 1 ) {
			System.out.println("회원을 선택하셨습니다. 로그인 화면으로 넘어갑니다.");
			Controllers.getLoginController().requestLogin();
			
		} else if (selectCheckUserOrder == 2 ) {
			System.out.println("비회원을 선택하셨습니다. 비회원 조회로 넘어갑니다.");
//			Controllers.getNonUserController()			
		} else {
			System.out.println("다시 선택해주세요.");
			checkUserOrder();
		}
	}
}
