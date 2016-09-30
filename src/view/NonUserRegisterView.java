package view;

import java.util.Scanner;

import controller.Controllers;
import domain.NonUser;

public class NonUserRegisterView {

	Scanner keyboard;

	public NonUserRegisterView() {

		keyboard = new Scanner(System.in);

	}

	// 비회원 사용자 등록 view
	public void nonUsertRegister() {

		String nonUserName = null;
		String nonUserTel = null;
		String nonUserAddress = null;
		
		System.out.println("[*] 비  회 원     주  문   [*] ");
		System.out.print("이   름 :");
		nonUserName = keyboard.next();
		System.out.print("전 화 번 호  :");
		nonUserTel = keyboard.next();
		System.out.print("주   소  :");
		nonUserAddress = keyboard.next();
		
		NonUser newNonUser = new NonUser(nonUserName, nonUserTel, nonUserAddress);

		Controllers.getNonUserController().requestReturnNonUserRegister(newNonUser);
	}

}
