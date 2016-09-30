package view;

import java.util.Scanner;

import controller.Controllers;
import domain.User;

public class UserRegisterView {

	private Scanner keyboard;

	public UserRegisterView() {

		keyboard = new Scanner(System.in);

	}

	public void userRegister() {

		String userId = null;
		String userPassword = null;
		String userName = null;
		String userTel = null;
		String userAddress = null;

		System.out.println("[*]   회   원      가   입      [*]");
		System.out.print(  "ID : ");
		userId = keyboard.next();
		System.out.print(  "Password : ");
		userPassword = keyboard.next();
		System.out.print(  "이  름 : ");
		userName = keyboard.next();
		System.out.print(  "전화 번호 : ");
		userTel = keyboard.next();
		System.out.print(  "  주소 : ");
		userAddress = keyboard.next();

		User newUser = new User(userId, userPassword, userName, userTel, userAddress);

		Controllers.getUserController().requestReturnRegister(newUser);
	}

}
