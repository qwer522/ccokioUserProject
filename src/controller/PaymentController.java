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

		int checking = paymentDao
		
		//결제 처리
		boolean success = paymentDao.userRegister();

		if(success) {
			//주문내역 삭제	
			new AlertView().alert("결제처리가 완료되었습니다.");
			// Controllers.getCartController().requestCartClear(); 장바구니 초기화 컨트롤 호출
		}

		//제품 목록 보기
		// Controllers.getProductController().requestSelectList(); 제품목록리스트 호출 메인화면
		new AlertView().alert("제품 컨트롤러의 제품 목록 보기를 요청함.");

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
			//결제내역없는거표시후 그다음 화면 호출
		}

	}

	public void requestNonUserPayment() { //비회원 결제목록 조회

		//dao호출
		ArrayList<NonUserPayment>nonUserPayments = paymentDao.nonUserPayment();

		if(nonUserPayments != null) {
			//view호출
			PaymentLisetView paymentListView = new PaymentLisetView();
			paymentListView.nonUserPaymentList(nonUserPayments);
		}else {
			new AlertView().alert("결제 내역이 없습니다.");
			//결제내역없는거표시후 그다음 화면 호출
		}

	}



}
