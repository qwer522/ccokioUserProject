package controller;

import java.util.ArrayList;

import dao.UserOrderDao;
import domain.Order;
import view.AlertView;
import view.OrderDeleteView;
import view.OrderSelectListView;
import view.OrderUpdateView;

public class UserOrderController {

	private UserOrderDao userOrderDao;

	public UserOrderController() {

		userOrderDao = new UserOrderDao();
	}

	// 1. 주문 등록
	public void requestOrderRegister() {

		boolean success = userOrderDao.orderRegister();

		if (success) {
			new AlertView().alert("주문이 되었습니다.");
		} else {
			new AlertView().alert("주문이 실패하였습니다.");
		}
	}

	// 2. 주문 목록
	public void requestOrderList() {

		// 주문 목록을 주문테이블에서 얻어 반환
		ArrayList<Order> orderList = userOrderDao.OrderSelectList();

		// 주문 목록을 화면에 표시
		OrderSelectListView orderSelectListView = new OrderSelectListView();
		orderSelectListView.orderSelectList(orderList);

	}

	// 2-1 회원 주문 확인
	public void requestCheckUserOrder() {

	}

	// 3. 주문 메뉴 선택
	public void requestOrderListMenu() {
		OrderSelectListView orderSelectListView = new OrderSelectListView();
		orderSelectListView.orderListMenu();
	}

	// 4. 주문 수정
	public void requestOrderUpdate() {

		OrderUpdateView orderUpdateView = new OrderUpdateView();
		orderUpdateView.selectOrderUpdateNumber();

	}

	// 주문수정 진행 메서드 호출
	public void requestorderUpdateProsess(int selectOrderNumber, int updateOrderAmount) {
		boolean success = userOrderDao.orderUpdate(selectOrderNumber, updateOrderAmount);

		if (success) {
			new AlertView().alert("주문 수량 수정에 성공했습니다!");
		} else {
			new AlertView().alert("주문 수량 수정에 실패했습니다.");
		}
	}

	// 5. 주문 취소
	public void requestOrderDelete() {

		OrderDeleteView orderDeleteView = new OrderDeleteView();
		orderDeleteView.selectOrderDeleteNumber();
	}

	// 주문 취소 진행 메서드 호출
	public void requestOrderDeleteProsess(int selectOrderNumber) {

		boolean success = userOrderDao.orderDelete(selectOrderNumber);

		if (success) {
			new AlertView().alert("주문 취소에 성공했습니다!");
		} else {
			new AlertView().alert("주문 취소에 실패했습니다.");
		}
	}

}
