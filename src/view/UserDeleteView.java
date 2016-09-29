package view;

import java.util.Scanner;

import controller.Controllers;

public class UserDeleteView {

	Scanner keyboard;

	public UserDeleteView() {

		keyboard = new Scanner(System.in);

	}

	public void userDelete() {

		while (true) {

			System.out.println("회원 탈퇴 모드");
			System.out.println("1. 회원 탈퇴");
			System.out.println("2. 목록으로");
			int number = keyboard.nextInt();

			if (number == 1) {
				Controllers.getUserController().requestUserDeleteProcessing();

			} else if (number == 2) {
				System.out.println("목록으로 돌아갑니다.");
				// 컨트롤러를 통하여 목록으로 이동
				break;

			} else {
				System.out.println("번호를 다시 입력하세요.");
			}
		}
			//완료시 메인매뉴로 다시 이동하는 컨트롤러 연결 필요
		Controllers.getMainController().requestMainView();
	}

}
