package controller;

import dao.LoginDao;
import domain.Login;
import view.AlertView;
import view.LoginView;

public class LoginController {

	private LoginDao loginDao;

	public LoginController() {

		loginDao = new LoginDao();

	}

	public void requestLogin() {

		// 로그인 정보 담아와서 Login 획득
		LoginView loginView = new LoginView();
		Login newLogin = loginView.login();

		boolean success = loginDao.logIn(newLogin);

		if (success) {
			new AlertView().alert("로그인 성공 하였습니다.");
			

		} else {
			new AlertView().alert("로그인 실패 하였습니다.");
		}

		// 제품 컨트롤러의 제품 목록 보기 화면으로 이동
		new AlertView().alert("제품 목록으로 이동");
		Controllers.getUserController().requestUserUpdate();
		// 컨트롤러를 통해 제품 목록으로 연결하여야함.

	}

	public boolean requestCheckLogin() {

		boolean success = loginDao.checkLogin();

		return success;

	}

	public void requestLogout(){
		
		// 로그아웃 하면서  리포지 토리에있는 카트정보삭제
		
		loginDao.logOut();
	}
}
