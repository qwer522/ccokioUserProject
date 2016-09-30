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

	public void requestReturnNonUserRegister(NonUser newNonUser) { //비회원 db에없을시 추가
		
		
		boolean success = nonUserDao.nonUserLogIn(newNonUser);//db에 등록된 비회원이 있는지 확인한다
		
		if (success) {//있으면 로그인됨
			new AlertView().alert("비회원 DB에 있어서 로그인 바로 됨");
			Controllers.getMainController().requestNonUserMainView();
		} else {//없으면 비회원 db에 추가 (관리자가 보기위해)
			success = false;
			success = nonUserDao.nonUserRegister(newNonUser);
			if(success) { 
				new AlertView().alert("비회원 DB등록 성공");
				Controllers.getMainController().requestNonUserMainView();
			}else {
				new AlertView().alert("비회원 DB등록 실패");
			Controllers.getMainController().requestMainView();
			}
		}
		
	}

}
