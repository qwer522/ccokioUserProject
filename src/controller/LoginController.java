package controller;

import dao.LoginDao;
import domain.Login;
import domain.Product;
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
		loginView.login();

	}
	
	public void requestLoginProcessing(Login newLogin) {
		
		boolean success = loginDao.logIn(newLogin);

		if (success) {
			new AlertView().alert("로그인 성공 하였습니다.");
			Controllers.getCartController().requestLoadCartList();
			Controllers.getMainController().requestUserMainView();
		} else {
			new AlertView().alert("아이디 또는 비밀번호가 틀립니다.");
			Controllers.getMainController().requestMainView();
		}

	}

	public void requestLogout(){ //회원 로그아웃

		// 로그아웃 하면서  리포지 토리에있는 카트정보삭제
		boolean success = loginDao.logOut();
		if(success == true) {
			Controllers.getMainController().requestMainView();
		}else {
			Controllers.getMainController().requestUserMainView();
		}

	}
	
	public void requestNonUserLogout(){ //비회원 로그아웃

		// 로그아웃 하면서  리포지 토리에있는 카트정보삭제
		boolean success = loginDao.nonUserLogOut();
		if(success == true) {
			Controllers.getMainController().requestMainView();
		}else {
			Controllers.getMainController().requestNonUserMainView();
		}

	}
	
	public void requsetCheckLogin(Product searchProduct){

		boolean success = loginDao.checkLogin();

		if(success){
			Controllers.getProductController().requestSelectOneMenu(searchProduct);
		} else {
			Controllers.getMainController().requestMainView();
		}

	}
}
