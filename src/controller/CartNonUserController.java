package controller;

import java.util.ArrayList;

import dao.CartDaoForNonUser;
import domain.CartNonUser;
import view.AlertView;
import view.CartNonUserListView;
import view.CartNonUserRegisterView;
import view.CartNonUserUpdateView;

public class CartNonUserController {

	private CartDaoForNonUser cartDaoForNonUser;	

	public CartNonUserController() {

		cartDaoForNonUser = new CartDaoForNonUser();
	}

<<<<<<< HEAD
	//0. db 불러오기
	public void requestloadCartNonUserList() { //DB 불러오기

		cartDaoForNonUser.cartNonUserClear();
=======
	public void requestloadCartNonUserList() { //DB 불러오기

		requestcartClear();
>>>>>>> refs/remotes/origin/master
		boolean success = cartDaoForNonUser.loadCartNonUserList();

		if(success) {
			new AlertView().alert("DB 불러오기 성공");
		} else {
			new AlertView().alert("DB 불러오기 실패");
			Controllers.getMainController().requestNonUserMainView();
		}

	}

<<<<<<< HEAD

	//1. 장바구니 등록
	public void requestCartNonUserRegister(int productNumber) {


		//수량 입력 화면
		CartNonUserRegisterView cartNonUserRegisterView = new CartNonUserRegisterView();
		cartNonUserRegisterView.cartNonUserRegister(productNumber);
	}
	
	//1-1 장바구니 등록 계속
	public void requestCartNonUserRegisterProccess(int productNumber, int orderCount) {
		
		boolean success = cartDaoForNonUser.cartNonUserRegister(productNumber, orderCount);

		if(success) {
			new AlertView().alert("장바구니에 넣었습니다!");

		} else {
			new AlertView().alert("장바구니 등록이 실패하였습니다.");
		}

		//장바구니 목록 보기 화면
		requestCartNonUserList();

	}

	//2. 장바구니 목록 (조회의 기능까지 포함 : 모든 정보 다 보여줄 것)
		public void requestCartNonUserList() {

			ArrayList<CartNonUser> CartNonUsers = cartDaoForNonUser.selectCartNonUserList();

			CartNonUserListView cartNonUserListView = new CartNonUserListView();
			cartNonUserListView.printCartNonUserList(CartNonUsers);

		}
	//2. 장바구니 수량 수정

		public void requestNonUserUpdateOrderAmount() {

			//view에서 상품번호와 수정할 수량번호 입력
			CartNonUserUpdateView cartNonUserUpdateView = new CartNonUserUpdateView();
			cartNonUserUpdateView.nonUserUpdateOrderCount();
		}

		public void requestNonUserUpdateOrderAmountProcess(int cartNumber, int updateOrderCount) {

			//dao 호출하여 장바구니 번호와 일치하면 수량 수정
			boolean success = cartDaoForNonUser.nonUserUpdateOrderAmount(cartNumber, updateOrderCount);

			if(success) {
				new AlertView().alert("수량을 수정하였습니다.");
			} else {
				new AlertView().alert("수량 수정에 실패하였습니다.");
			}
			requestCartNonUserList();
		}


	//3. 장바구니 삭제
		public void requestCartNonUserDeleteOne() {

			CartNonUserUpdateView cartNonUserUpdateView = new CartNonUserUpdateView();
			cartNonUserUpdateView.nonUserDeleteCart();
		}


		public void requestCartNonUserDeleteOneProcess(int cartNumber) {

			boolean success = cartDaoForNonUser.cartNonUserDeleteOne(cartNumber);

			if (success) {
				new AlertView().alert("선택하신 주문을 장바구니에서 삭제하였습니다.");
			} else {
				new AlertView().alert("선택하신 주문을 장바구니에서 삭제 실패하였습니다.");
			}
			requestCartNonUserList();
		}
		
		//4. 장바구니 메뉴 불러오기
		public void requestNonUserCartView() {

			CartNonUserListView cartNonUserListView = new CartNonUserListView();
			cartNonUserListView.nonUserCartView();

			
		}
=======
	public void requestcartClear() { //비회원 장바구니 클리어

		boolean success = cartDaoForNonUser.cartClear();

		if(success) {
			new AlertView().alert("비회원 장바구니 클리어 성공");
		} else {
			new AlertView().alert("비회원 장바구니 클리어 실패");
		}
	}

>>>>>>> refs/remotes/origin/master
}
