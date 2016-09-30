package controller;

import dao.OrderUserDao;
import view.AlertView;
import view.OrderView;

public class OrderUserController {

	private OrderUserDao orderUserDao;
	
	public OrderUserController() {
		orderUserDao = new OrderUserDao();
	}

	public void requestOrderRegister() { //장바구니를 주문에 저장
		
		boolean success = orderUserDao.orderRegister();
		
		if(success) {
			new AlertView().alert("주문 DB에 저장 성공 ");
			OrderView orderUserView = new OrderView();
			orderUserView.orderUser();
		}else {
			new AlertView().alert("주문 DB에 저장 실패 ");
			Controllers.getCartController().requestUserCartView();
		}
		
	}

}
