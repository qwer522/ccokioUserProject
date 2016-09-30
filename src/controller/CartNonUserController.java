package controller;

import dao.CartDaoForNonUser;
import view.AlertView;

public class CartNonUserController {

	private CartDaoForNonUser cartDaoForNonUser;	

	public CartNonUserController() {

		cartDaoForNonUser = new CartDaoForNonUser();
	}

	public void requestloadCartNonUserList() { //DB 불러오기

		requestcartClear();
		boolean success = cartDaoForNonUser.loadCartNonUserList();

		if(success) {
			new AlertView().alert("DB 불러오기 성공");
		} else {
			new AlertView().alert("DB 불러오기 실패");
			Controllers.getMainController().requestMainView();
		}

	}

	public void requestcartClear() { //비회원 장바구니 클리어

		boolean success = cartDaoForNonUser.cartClear();

		if(success) {
			new AlertView().alert("비회원 장바구니 클리어 성공");
		} else {
			new AlertView().alert("비회원 장바구니 클리어 실패");
		}
	}

}
