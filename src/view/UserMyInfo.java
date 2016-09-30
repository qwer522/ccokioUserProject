package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controllers;

public class UserMyInfo {

	Scanner keyboard;

	public UserMyInfo() {

		keyboard = new Scanner(System.in);

	}

	public void UserInfoMenu(){
		
		try {
			//치킨 메뉴 호출해주기 설명없는 거로
			Controllers.getUserController().requestUserinfoShowView();

			System.out.println("[1] 내    정     보     수    정");
			System.out.println("[2] 회       원        탈      퇴");
			System.out.println("[3] 메      인      매   뉴   로");
			
			while(true) {
				
				int number = keyboard.nextInt();
				if(number == 1){
					Controllers.getUserController().requestUserUpdate();
				}else if(number == 2){
					Controllers.getUserController().requestUserDeleteProcessing();
				}else if(number == 3){
					Controllers.getMainController().requestUserMainView();
				}else {
					System.out.println("번호를 다시 입력해 주세요.");
				}
				
			}
		} catch (InputMismatchException e) {
			System.out.println("올바른 입력을 입력해주세요.");
			Controllers.getUserController().requestUserInfo();
		}
			

	}

}
