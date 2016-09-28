package view;

import java.util.Scanner;

import controller.Controllers;

public class MainView {

	private Scanner keyboard;

	public MainView() {
		keyboard = new Scanner(System.in);
	}

	public void mainView() {

		//치킨 메뉴 호출해주기 설명없는 거로

		System.out.println("1. 메뉴 조회");
		System.out.println("2. 로그인");
		System.out.println("3. 비회원 주문");
		System.out.println("4. 주문내역확인");
		System.out.println("5. 회원가입");
		System.out.println("0. 종료");

		int mainViewNumber = keyboard.nextInt();
		if(mainViewNumber == 1){

		}else if(mainViewNumber == 2){
			Controllers.getLoginController().requestLogin(); //로그인 메서드 호출
		}else if(mainViewNumber == 3){
			Controllers.getNonUserController().requestNonUserRegister(); // 비회원 주문 메서드 호출
		}else if(mainViewNumber == 4){

		}else if(mainViewNumber == 5){
			Controllers.getUserController().requestRegister();
		}else if(mainViewNumber == 0){
			System.out.println("꼬끼오 프로그램을 종료합니다.");
			System.exit(0);
		}else {
			Controllers.getMainController().requestMainView();
		}
	}

	public void userMainView() {

		//치킨 메뉴 호출해주기 설명없는 거로

		System.out.println("1. 메뉴 조회");
		System.out.println("2. 장바구니");
		System.out.println("3. 내정보");
		System.out.println("4. 로그아웃");

		int userMainViewNumber = keyboard.nextInt();
		if(userMainViewNumber == 1){

		}else if(userMainViewNumber == 2){

		}else if(userMainViewNumber == 3){

		}else if(userMainViewNumber == 4){

		}else {
			Controllers.getMainController().requestUserMainView();
		}
	}

	public void nonUserMainView() {

		//치킨 메뉴 호출해주기 설명없는 거로

		System.out.println("1. 메뉴 조회");
		System.out.println("2. 장바구니");
		System.out.println("3. 메인화면");

		int nonUserMainViewNumber = keyboard.nextInt();
		if(nonUserMainViewNumber == 1){

		}else if(nonUserMainViewNumber == 2){

		}else if(nonUserMainViewNumber == 3){
			Controllers.getMainController().requestMainView();
		}else {
			Controllers.getMainController().requestNonUserMainView();
		}
	}


}
