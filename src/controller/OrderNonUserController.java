package controller;

import dao.OrderNonUserDao;
import view.AlertView;
import view.OrderView;

public class OrderNonUserController {

	OrderNonUserDao orderNonUserDao;
	
	public OrderNonUserController() {
		orderNonUserDao	= new OrderNonUserDao();
	}

	public void requestOrderRegister() { //장바구니를 주문에 저장

		boolean success = orderNonUserDao.orderNonUserRegister();

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
