package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.Login;
import domain.NonUserPayment;
import domain.UserPayment;

public class PaymentLisetView {

	private Scanner keyboard;

	public void paymentListView() {
		keyboard = new Scanner(System.in);
	}

	public void checkingUserOrNonUser() { //결제확인을 위한 회원인지 비회원인지 선택

		while(true) {
			System.out.println("1. 회원");
			System.out.println("2. 비회원");
			int number = keyboard.nextInt();

			if(number == 1) {

			}else if(number == 2) {

			}else {

			}

		}

	}

	public void userLogin(){ //결제확인을 위한 회원 로그인

		System.out.println("\n[*]  회   원   로   그   인        [*]   ") ;

		System.out.print("ID : ");
		String loginId = keyboard.next();
		
		System.out.print("Password : ");
		String loginPassword = keyboard.next();

		Login newLogin = new Login(loginId, loginPassword);

		Controllers.getPaymentController().requestUserLoginProcessing(newLogin);

	}

	public void userPaymentList(ArrayList<UserPayment> userPayments) { //회원결제목록 보기

		int sum = 0;

		System.out.println("[*]  결   제    내    역    정  보    조   회  [*]");
		System.out.println("[*]     등급   별로   할인   적용           [*]");
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

			sum = sum + userPayments.get(i).getOrderSum();
		}

		System.out.println("총 가격 : " + sum);
		Controllers.getMainController().requestMainView();
	}

	public void nonUserPaymentList(ArrayList<NonUserPayment> nonUserPayments) {//비회원결제목록 보기

		int sum = 0;

		System.out.println("[*] 결    제    내   역  정    보    조   회  [*]");
		System.out.println("결제번호\t비회원Tel\t주문번호\t제품이름\t수량\t가격\t합계\t주문날짜");
		for(int i = 0 ; i < nonUserPayments.size(); i++) {

			System.out.print(nonUserPayments.get(i).getPaymentNumber() + "\t");
			System.out.print(nonUserPayments.get(i).getUserId() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderNumber() + "\t");
			System.out.print(nonUserPayments.get(i).getProductName() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderCount() + "\t");
			System.out.print(nonUserPayments.get(i).getProudctPrice() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderSum() + "\t");
			System.out.println(nonUserPayments.get(i).getPaymentDate());

			sum = sum + nonUserPayments.get(i).getOrderSum();
		}
		System.out.println("총 가격 : " + sum);
		Controllers.getMainController().requestMainView();
	}

}
