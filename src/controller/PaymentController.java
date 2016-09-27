package controller;

import dao.PaymentDao;
import view.AlertView;

public class PaymentController {

	private PaymentDao paymentDao;
	
	public PaymentController() {
		
		paymentDao = new PaymentDao();
		
	}

	//결제 요청 처리를 위한 메서드
	public void requestRegister() {
		
		//결제 처리
		boolean success = paymentDao.register();
		
		if(success) {
			//주문내역 삭제	
			new AlertView().alert("결제처리가 완료되었습니다.");
			// Controllers.getCartController().requestCartClear(); 장바구니 초기화 컨트롤 호출
		}
		
		//제품 목록 보기
		// Controllers.getProductController().requestSelectList(); 제품목록리스트 호출 메인화면
		new AlertView().alert("제품 컨트롤러의 제품 목록 보기를 요청함.");
		
	}
	
//	public void requestMyPayment() { //나의 결제목록 조회
//		
//		//dao호출
//		ArrayList<Payment> myPayments = paymentDao.myPayment();
//		
//		if(myPayments != null) {
//			//view호출
//			PaymentLisetView paymentListView = new PaymentLisetView();
//			paymentListView.myPaymentList(myPayments);
//		}else {
//			new AlertView().alert("결제 내역이 없습니다.");
//			Controllers.getUserController().requestMyInfor();
//		}
//		
//		
//	}
//	
	
	
}
