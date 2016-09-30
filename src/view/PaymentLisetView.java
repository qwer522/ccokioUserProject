package view;

import java.util.ArrayList;

import controller.Controllers;
import domain.NonUserPayment;
import domain.UserPayment;

public class PaymentLisetView {

	public void paymentListView() {

	}

	public void userPaymentList(ArrayList<UserPayment> userPayments) { //회원결제목록 보기

		System.out.println("[*]  결   제    내    역    정  보    조   회  [*]");
		System.out.println("결제번호\tID\t회원등급\t주문번호\t제품이름\t수량\t사용한쿠폰\t가격\t합계\t주문날짜");
		for(int i = 0 ; i < userPayments.size(); i++) {

			System.out.print(userPayments.get(i).getPaymentNumber() + "\t");
			System.out.print(userPayments.get(i).getUserId() + "\t");
			System.out.print(userPayments.get(i).getUserClass() + "\t");
			System.out.print(userPayments.get(i).getOrderNumber() + "\t");
			System.out.print(userPayments.get(i).getProductName() + "\t");
			System.out.print(userPayments.get(i).getOrderCount() + "\t");
			System.out.print(userPayments.get(i).getCouponuseAmount() + "\t");
			System.out.print(userPayments.get(i).getProductPrice() + "\t");
			System.out.print(userPayments.get(i).getOrderSum() + "\t");
			System.out.println(userPayments.get(i).getPaymentDate());
			

		}
		Controllers.getMainController().requestMainView();
	}

	public void nonUserPaymentList(ArrayList<NonUserPayment> nonUserPayments) {//비회원결제목록 보기

		System.out.println("[*] 결    제    내   역  정    보    조   회  [*]");
		System.out.println("결제번호\t비회원Tel\t주문번호\t제품이름\t수량\t가격\t주문날짜");
		for(int i = 0 ; i < nonUserPayments.size(); i++) {

			System.out.print(nonUserPayments.get(i).getPaymentNumber() + "\t");
			System.out.print(nonUserPayments.get(i).getUserId() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderNumber() + "\t");
			System.out.print(nonUserPayments.get(i).getProductName() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderCount() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderSum() + "\t");
			System.out.println(nonUserPayments.get(i).getPaymentDate());

		}
		Controllers.getMainController().requestMainView();
	}
	
}
