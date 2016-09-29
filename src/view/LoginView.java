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
		
		System.out.print("[*]   아       이        디      [*] : ");
		String loginId = keyboard.next();
		
		System.out.print("[*]   비    밀    번     호      [*] : ");
		String loginPassword = keyboard.next();
		
		Login newLogin = new Login(loginId, loginPassword);
	
		Controllers.getLoginController().requestLoginProcessing(newLogin);
		
	}

}
