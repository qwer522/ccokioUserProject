package controller;

import view.MainView;

public class MainController {

	public MainController() {

	}

	public void requestMainView() { //메인화면
		MainView mainView = new MainView();
		mainView.mainView();
	}

	public void requestUserMainView() {//회원
		MainView userMainView = new MainView();
		userMainView.userMainView();
	}
	
	public void requestNonUserMainView() {//비회원
		MainView nonUserMainView = new MainView();
		nonUserMainView.nonUserMainView();
	}

	public void requestUserCartView() { //회원 장바구니 메뉴
		MainView userCartView = new MainView();
		userCartView.userCartView();
	}
}	