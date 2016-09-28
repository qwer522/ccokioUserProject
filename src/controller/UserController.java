package controller;

import dao.UserDao;
import domain.User;
import view.AlertView;
import view.UserRegisterView;

public class UserController {

	UserDao userDao;

	public UserController() {

		userDao = new UserDao();

	}

	// 회원 가입 요청 메서드
	public void requestRegister() {

		UserRegisterView userRegisterView = new UserRegisterView();
		userRegisterView.userRegister();

	}

	public void requestReturnRegister(User newUser) {

		boolean success = userDao.userRegister(newUser);

		if (success) {
			new AlertView().alert("회원가입을 성공했습니다.");
		} else {
			new AlertView().alert("중복된 아이디가 있습니다.");
		}
		Controllers.getMainController().requestMainView();
		
	}

}
