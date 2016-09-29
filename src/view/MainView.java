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
			Controllers.getUserOrderController().requestCheckUserOrder(); 
		}else if(mainViewNumber == 5){
			Controllers.getUserController().requestRegister(); //회원가입
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
			Controllers.getCartController().requestCartList();
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

	public void userCartView() {
		
		//장바구니 목록에 출력되는 메뉴
		System.out.println("1. 제품 목록 보기");
		System.out.println("2. 주문");
		System.out.println("3. 장바구니 상품 수량 수정");
		System.out.println("4. 장바구니 상품 삭제");
		System.out.println("5. 장바구니 비우기");
		
		
		int selectedMenu = keyboard.nextInt();

		switch (selectedMenu) {
		case 1:
			new AlertView().alert("제품 컨트롤러에 제품 목록 보기를 요청함.");
//			Controllers.getProductController().requestSelectList();
			break;
		case 2:
			new AlertView().alert("주문 컨트롤러에 주문를 요청함.");
//			Controllers.getOrderController().requestRegister();
			break;
		case 3:
			new AlertView().alert("장바구니 컨트롤러에 장바구니 상품 수정을 요청함.");
			Controllers.getCartController().requestUpdateOrderAmount(); 
			break;
		case 4:
			new AlertView().alert("장바구니 컨트롤러에 장바구니 상품 삭제를 요청함.");
			Controllers.getCartController().requestCartDeleteOne();
			break;
		case 5:
			new AlertView().alert("장바구니 컨트롤러에 장바구니 비우기를 요청함.");
			Controllers.getCartController().requestCartClear();
		case 0:
			new AlertView().alert("프로그램 컨트롤러에 프로그램 종료를 요청함.");
			Controllers.getProgramController().requestExitProgram();
			break;
		default:
			new AlertView().alert("메뉴를 다시 선택해 주세요.");
		}
	}

}
