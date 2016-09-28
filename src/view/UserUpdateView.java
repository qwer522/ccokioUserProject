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
		
		User user = null;
		
		System.out.println("회원정보 수정");
		
		System.out.print("수정할 비밀번호 : ");
		String userPassword = keyboard.next();
		
		
		System.out.print("수정할 전화번호");
		String userTel = keyboard.next();
	
		
		System.out.print("수정할 주소지");
		String userAddress = keyboard.next();
		
		user = new User(userPassword, userTel, userAddress);
		
		
			
		Controllers.getUserController().requestUserUpdateProsccesing(user);
		}

	}


