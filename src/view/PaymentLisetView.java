package view;

import java.util.ArrayList;

import domain.NonUserPayment;
import domain.UserPayment;

public class PaymentLisetView {

	public void paymentListView() {

	}

	public void userPaymentList(ArrayList<UserPayment> userPayments) { //회원결제목록 보기

		System.out.println("[결제 내역 정보 조회]");
		System.out.println("결제번호\tID\t주문번호\t제품이름\t수량\t가격\t주문날짜");
		for(int i = 0 ; i < userPayments.size(); i++) {

			System.out.print(userPayments.get(i).getPaymentNumber() + "\t");
			System.out.print(userPayments.get(i).getUserId() + "\t");
			System.out.print(userPayments.get(i).getOrderNumber() + "\t");
			System.out.print(userPayments.get(i).getProductName() + "\t");
			System.out.print(userPayments.get(i).getOrderCount() + "\t");
			System.out.print(userPayments.get(i).getOrderCount() + "\t");
			System.out.println(userPayments.get(i).getOrderSum());

		}
		//결제내역정보보고 그다음화면 호출
	}

	public void nonUserPaymentList(ArrayList<NonUserPayment> nonUserPayments) {//비회원결제목록 보기

		System.out.println("[결제 내역 정보 조회]");
		System.out.println("결제번호\t비회원Tel\t주문번호\t제품이름\t수량\t가격\t주문날짜");
		for(int i = 0 ; i < nonUserPayments.size(); i++) {

			System.out.print(nonUserPayments.get(i).getPaymentNumber() + "\t");
			System.out.print(nonUserPayments.get(i).getUserId() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderNumber() + "\t");
			System.out.print(nonUserPayments.get(i).getProductName() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderCount() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderCount() + "\t");
			System.out.println(nonUserPayments.get(i).getOrderSum());

		}
		//결제내역정보보고 그다음화면 호출
	}

}
