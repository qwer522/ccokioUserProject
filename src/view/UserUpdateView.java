package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controllers;
import domain.User;

public class UserUpdateView {

	private Scanner keyboard;

	public UserUpdateView() {

		keyboard = new Scanner(System.in);

	}

	public void userUpdate() {

		try {
			System.out.println("[*]   회   원     수    정      [*]");

			System.out.print(  "변경될 비밀번호 : ");
			String userPassword = keyboard.next();


			System.out.print(  "변경될 전화번호 : ");
			String userTel = keyboard.next();


			System.out.print(  "변경될 주  소 : ");
			String userAddress = keyboard.next();

			User user = new User(userPassword, userTel, userAddress);



			Controllers.getUserController().requestUserUpdateProsccesing(user);
		} catch (InputMismatchException e) {
			System.out.println("올바른 입력을 입력해주세요.");
			Controllers.getUserController().requestUserUpdate();
		}

	}


}
