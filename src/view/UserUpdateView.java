package view;

import java.util.Scanner;

import controller.Controllers;
import domain.User;

public class UserUpdateView {

	private Scanner keyboard;

	public UserUpdateView() {

		keyboard = new Scanner(System.in);

	}

	public void userUpdate() {
		
		System.out.println("[*]   회   원     수    정      [*]");
		
		System.out.print(  "변경될 비밀번호 : ");
		String userPassword = keyboard.next();
		
		
		System.out.print(  "변경될 전화번호 : ");
		String userTel = keyboard.next();
	
		
		System.out.print(  "변경될 주  소 : ");
		String userAddress = keyboard.next();
		
		User user = new User(userPassword, userTel, userAddress);
		
		
			
		Controllers.getUserController().requestUserUpdateProsccesing(user);
		}

	
}
