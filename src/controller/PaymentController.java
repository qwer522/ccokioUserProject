package controller;

import java.util.ArrayList;

import dao.PaymentDao;
import domain.NonUserPayment;
import domain.UserPayment;
import view.AlertView;
import view.PaymentLisetView;

public class PaymentController {

	private PaymentDao paymentDao;

	public PaymentController() {

		paymentDao = new PaymentDao();

	}
	
	public void requestRegister() { //결제 요청 처리를 위한 메서드
		
		//회원인지 비회원인지 체크 1이면 회원 2이면 비회원 다른거는 오류
		int checking = paymentDao.Loginchecking();
		
		if(checking == 1) { //회원일때 결제처리
			boolean success = paymentDao.userRegister();
			if(success) {
				new AlertView().alert("결제처리가 완료되었습니다.");
				// Controllers.getCartController().requestCartClear(); 장바구니 초기화 컨트롤 호출
			}
			Controllers.getMainController().requestUserMainView();
		}else if(checking == 2) {//비회원일때 결제처리 
			boolean success = paymentDao.nonUserRegister();
			if(success) {
				new AlertView().alert("결제처리가 완료되었습니다.");
				// Controllers.getCartController().requestCartClear(); 장바구니 초기화 컨트롤 호출
			}
			Controllers.getMainController().requestNonUserMainView();
		}else {//오류
			new AlertView().alert("결제 오류");
			Controllers.getMainController().requestMainView();
		}
		

	}

	public void requestUserPayment() { //회원 결제목록 조회

		//dao호출
		ArrayList<UserPayment> userPayments = paymentDao.userPayment();

		if(userPayments != null) {
			//view호출
			PaymentLisetView paymentListView = new PaymentLisetView();
			paymentListView.userPaymentList(userPayments);
		}else {
			new AlertView().alert("결제 내역이 없습니다.");
			Controllers.getMainController().requestMainView();
		}

	}

	public void requestNonUserPayment() { //비회원 결제목록 조회

		//dao호출
		ArrayList<NonUserPayment> nonUserPayments = paymentDao.nonUserPayment();

		if(nonUserPayments != null) {
			//view호출
			PaymentLisetView paymentListView = new PaymentLisetView();
			paymentListView.nonUserPaymentList(nonUserPayments);
		}else {
			new AlertView().alert("결제 내역이 없습니다.");
			Controllers.getMainController().requestMainView();
		}

	}



}
