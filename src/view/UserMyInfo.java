package view;

import java.util.Scanner;

import controller.Controllers;

public class UserMyInfo {
	
	Scanner keyboard;
	
	public UserMyInfo() {

		keyboard = new Scanner(System.in);
		
	}
	
	public void UserInfoMenu(){
		
	{

			//치킨 메뉴 호출해주기 설명없는 거로
			Controllers.getUserController().requestUserinfoShowView();
			
			System.out.println("1. 내 정보 수정");
			System.out.println("2. 회원 탈퇴");
			System.out.println("3. 메인 매뉴로");

			int number = keyboard.nextInt();
			if(number == 1){
				Controllers.getUserController().requestUserUpdate();
			}else if(number == 2){
				Controllers.getUserController().requestUserDeleteProcessing();
			}else if(number == 3){
				Controllers.getMainController().requestUserMainView();
			}else {
				Controllers.getMainController().requestUserMainView();
			}
		}
		
		
	}

}
