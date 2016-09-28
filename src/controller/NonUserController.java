package controller;

import dao.NonUserDao;
import domain.NonUser;
import view.AlertView;
import view.NonUserRegisterView;

public class NonUserController {

	NonUserDao nonUserDao;

	public NonUserController() {

		nonUserDao = new NonUserDao();
	}

	// 비회원 사용자 등록
	public void requestNonUserRegister() {

		// 비회원 사용자 이름과 전화번호를 입력 받는 뷰
		NonUserRegisterView nonUserRegisterView = new NonUserRegisterView();
		nonUserRegisterView.nonUsertRegister();

	}

	public void requestReturnNonUserRegister(NonUser newNonUser) {

		// 이름과 전화번호를 비회원 repository에 넣는 dao
		boolean success = nonUserDao.nonUserRegister(newNonUser);

		if (success) {
			new AlertView().alert("비회원 등록 성공 ");
		} else {
			new AlertView().alert("비회원 등록 실패");
		}
		Controllers.getMainController().requestNonUserMainView();
	}

}
