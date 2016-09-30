package controller;

import dao.CartDaoForNonUser;
import view.AlertView;

public class CartNonUserController {

	private CartDaoForNonUser cartDaoForNonUser;	

	public CartNonUserController() {

		cartDaoForNonUser = new CartDaoForNonUser();
	}
	
	public void requestloadCartNonUserList() { //DB 불러오기
		
		cartDaoForNonUser.cartClear();
		boolean success = cartDaoForNonUser.loadCartNonUserList();
		
		if(success) {
			new AlertView().alert("DB 불러오기 성공");
		} else {
			new AlertView().alert("DB 불러오기 실패");
			Controllers.getMainController().requestMainView();
		}
		
	}
		
}
