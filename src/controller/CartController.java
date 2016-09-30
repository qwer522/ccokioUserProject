package controller;

import java.util.ArrayList;

import dao.CartDaoForUser;
import domain.Cart;
import view.AlertView;
import view.CartListView;
import view.CartRegisterView;
import view.CartUpdateView;

public class CartController {

	private CartDaoForUser CartDaoForUser;	

	public CartController() {

		CartDaoForUser = new CartDaoForUser();
	}

	//0. 처음 로그인 시 DB에 있는 결제되지 않은 주문목록 장바구니로 불러오는 메서드 호출
	public void requestLoadCartList() {

		CartDaoForUser.cartClear();
		boolean success = CartDaoForUser.loadCartList();

		if(success) {
			new AlertView().alert("db 불러오기 성공");
		} else {
			new AlertView().alert("db 불러오기 실패");
			Controllers.getMainController().requestMainView();
		}
	}


	//1. 장바구니에 상품 등록 메서드 호출
	public void requestCartRegister(int productNumber) {


		//수량 입력 화면
		CartRegisterView cartRegisterView = new CartRegisterView();
		int orderCount = cartRegisterView.cartRegister(productNumber);

		boolean success = CartDaoForUser.CartRegister(productNumber, orderCount);

		if(success) {
			new AlertView().alert("장바구니에 넣었습니다!");

		} else {
			new AlertView().alert("장바구니 등록이 실패하였습니다.");
		}

		//장바구니 목록 보기 화면
		requestCartList();

	}


	//2. 장바구니 목록 (조회의 기능까지 포함 : 모든 정보 다 보여줄 것)
	public void requestCartList() {

		ArrayList<Cart> carts = CartDaoForUser.selectCartList();

		CartListView cartListView = new CartListView();
		cartListView.printCartList(carts);

	}

	//3. 장바구니  수정 (수량)
	public void requestUpdateOrderAmount() {

		//view에서 상품번호와 수정할 수량번호 입력
		CartUpdateView cartUpdateView = new CartUpdateView();
		cartUpdateView.updateOrderCount();
	}

	public void requestUpdateOrderAmountProcess(int cartNumber, int updateOrderCount) {

		//dao 호출하여 장바구니 번호와 일치하면 수량 수정
		boolean success = CartDaoForUser.updateOrderAmount(cartNumber, updateOrderCount);

		if(success) {
			new AlertView().alert("수량을 수정하였습니다.");
		} else {
			new AlertView().alert("수량 수정에 실패하였습니다.");
		}
		requestCartList();
	}


	//4. 회원 장바구니 비우기
	public void requestCartClear() {

		boolean success = CartDaoForUser.cartClear();

		if(success) {
			new AlertView().alert("장바구니를 비웠습니다.");
		} else {
			new AlertView().alert("장바구니 비우기에 실패하였습니다.");
		}

	}

	//5. 장바구니 상품 삭제
	public void requestCartDeleteOne() {

		CartUpdateView cartUpdateView = new CartUpdateView();
		cartUpdateView.deleteCart();
	}


	public void requestCartDeleteOneProcess(int cartNumber) {

		boolean success = CartDaoForUser.cartDeleteOne(cartNumber);

		if (success) {
			new AlertView().alert("선택하신 주문을 장바구니에서 삭제하였습니다.");
		} else {
			new AlertView().alert("선택하신 주문을 장바구니에서 삭제 실패하였습니다.");
		}
		requestCartList();
	}

	public void requestUserCartView() { //회원 장바구니 메뉴

		CartListView cartListView = new CartListView();
		cartListView.userCartView();

	}

}
