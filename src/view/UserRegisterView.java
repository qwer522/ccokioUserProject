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
		System.out.print(  "[*]   아      이      디         [*] : ");
		userId = keyboard.next();
		System.out.print(  "[*]   비      밀   번    호     [*] : ");
		userPassword = keyboard.next();
		System.out.print(  "[*]   이                  름      [*] : ");
		userName = keyboard.next();
		System.out.print(  "[*]   전      화   번    호     [*] : ");
		userTel = keyboard.next();
		System.out.print(  "[*]   주                  소      [*] : ");
		userAddress = keyboard.next();

		User newUser = new User(userId, userPassword, userName, userTel, userAddress);

		Controllers.getUserController().requestReturnRegister(newUser);
	}

}
