package controller;

import java.util.ArrayList;

import dao.PaymentDao;
import domain.NonUserPayment;
import domain.UserPayment;
import view.AlertView;
import view.PaymentCouponView;
import view.PaymentLisetView;

public class PaymentController {

	private PaymentDao paymentDao;

	public PaymentController() {

		paymentDao = new PaymentDao();

	}

	public void requestUserRegisterCouponChecking() { //회원 결제시 쿠폰 확인


		int userCoupon = paymentDao.couponChecking();
		
		PaymentCouponView paymentCouponView = new PaymentCouponView();
		paymentCouponView.couponCheckingView(userCoupon);

	}
	
	public void requestUserRegisterCouponUse() { //쿠폰을 사용한다.
		
		
		
	}

	public void requestUserRegister() { //회원 결제 요청 처리를 위한 메서드

		boolean success = paymentDao.userRegister();
		
		if(success) {
			new AlertView().alert("결제처리가 완료되었습니다.");
			// Controllers.getCartController().requestCartClear(); 장바구니 초기화 컨트롤 호출
		}else {//오류
			new AlertView().alert("결제 오류");
		}
		Controllers.getMainController().requestUserMainView();

	}

	public void requestNonUserRegister() { //비회원 결제 요청 처리를 위한 메서드

		boolean success = paymentDao.nonUserRegister();

		if(success) {
			new AlertView().alert("결제처리가 완료되었습니다.");
			// Controllers.getCartController().requestCartClear(); 장바구니 초기화 컨트롤 호출
		}else {//오류
			new AlertView().alert("결제 오류");
		}
		Controllers.getMainController().requestNonUserMainView();

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
