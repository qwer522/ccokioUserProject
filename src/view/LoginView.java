package view;

import java.util.Scanner;

import domain.Login;

public class LoginView {
	
	private Scanner keyboard;
	
	public LoginView() {

		keyboard = new Scanner(System.in);
		
	}
	
	
	// 로그인 정보 입력
	
	public Login login(){
		
		String loginId = null;
		String loginPassword = null;
		
		System.out.println("\n[로그인 모드]");
		
		System.out.print("회원 아이디 : ");
		loginId = keyboard.next();
		
		System.out.print("회원 비밀번호: ");
		loginPassword = keyboard.next();
		
		Login newLogin = new Login(loginId, loginPassword);
	
		return newLogin;
		
		
	}

}
