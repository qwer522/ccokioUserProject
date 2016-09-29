package controller;

import java.util.ArrayList;

import dao.PaymentDao;
import domain.Cart;
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

	public void requestCouponUseNumber(int couponuseNumber) { //쿠폰사용될번호가 있는지 확인

		boolean success = paymentDao.couponUseNumber(couponuseNumber);
		if(success) {
			PaymentCouponView paymentCouponView = new PaymentCouponView();
			paymentCouponView.couponAmountUseView(couponuseNumber);
		}else {
			new AlertView().alert("쿠폰사용될 번호가 없습니다.");
			requestUserCouponUse();
		}
		
	}
	
	public void requestUseCouponAmount(int couponuseAmount, int couponuseNumber) { //쿠폰사용 개수 맞는지 확인 맞으면 사용된다

		boolean success = paymentDao.CouponAmountUseNumber(couponuseAmount,couponuseNumber);
		if(success) {
			requestUserCouponUse();
		}else {
			new AlertView().alert("쿠폰 부족 또는 수량보다 쿠폰이 많습니다.");
			requestUserCouponUse();
		}
		
	}

	public void requestUserRegister() { //회원이 결제시 최초로 실행되는부분

		int userCoupon = paymentDao.couponChecking(); //쿠폰확인
		
		if(userCoupon == 1){ // 쿠폰이 10개 이상이면 실행
			requestUserCouponUse();
		}else { //10개 이하이면 바로 결제시행
			requestUserRegisterProcessing();
		}

	}
	
	public void requestUserCouponUse() { //db 불러와서 보여준다 쿠폰사용을 위해

		//쿠폰 사용을 위해 주문 db 불러오기 
		Controllers.getCartController().requestLoadCartList();
		ArrayList<Cart> carts = paymentDao.selectCartList();
		
		int couponHonorablyAmount = paymentDao.couponHonorablyAmount();
		double totalPrice = paymentDao.totalPrice();
		String userClass = paymentDao.userClass();
		
		PaymentCouponView paymentCouponView = new PaymentCouponView();
		paymentCouponView.couponUseView(carts, couponHonorablyAmount, userClass, totalPrice);

	}
	
	public void requestUserRegisterProcessing () { //회원 결제 요청 처리 실행

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

	public void requestUserPaymentList() { //회원 결제목록 조회

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

	public void requestNonUserPaymentList() { //비회원 결제목록 조회

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
