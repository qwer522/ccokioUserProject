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

		System.out.println("[회원 가입 모드]");
		System.out.print("아이디 : ");
		userId = keyboard.next();
		System.out.print("비밀번호 : ");
		userPassword = keyboard.next();
		System.out.print("이름 : ");
		userName = keyboard.next();
		System.out.print("전화번호 : ");
		userTel = keyboard.next();
		System.out.print("주소 : ");
		userAddress = keyboard.next();

		User newUser = new User(userId, userPassword, userName, userTel, userAddress);

		Controllers.getUserController().requestReturnRegister(newUser);
	}

}
