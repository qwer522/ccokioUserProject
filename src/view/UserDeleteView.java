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

			System.out.println("[*]  회  원   탈  퇴   모  드  [*]");
			System.out.println("[1]  회      원       탈      퇴");
			System.out.println("[2]  목      록      으       로");
			int number = keyboard.nextInt();

			if (number == 1) {
				Controllers.getUserController().requestUserDeleteProcessing();

			} else if (number == 2) {
				System.out.println("[*] 목  록 으 로   돌   아  갑  니  다   [*]");
				Controllers.getMainController().requestUserMainView();
				break;

			} else {
				System.out.println("[*]  번  호  를  다  시  입  력  하   세  요[*]");
			}
		}
	}

}
