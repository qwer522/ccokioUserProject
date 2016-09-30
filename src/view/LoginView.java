package view;

import java.util.Scanner;

import controller.Controllers;
import domain.Login;

public class LoginView {
	
	private Scanner keyboard;
	
	public LoginView() {

		keyboard = new Scanner(System.in);
		
	}
	
	
	// 로그인 정보 입력
	
	public void login(){
		
		System.out.println("\n[*]     로     그     인          [*]   ") ;
		
		System.out.print("ID : ");
		String loginId = keyboard.next();
		
		System.out.print("Password : ");
		String loginPassword = keyboard.next();
		
		Login newLogin = new Login(loginId, loginPassword);
	
		Controllers.getLoginController().requestLoginProcessing(newLogin);
		
	}

}
