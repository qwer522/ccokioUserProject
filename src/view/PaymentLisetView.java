package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controllers;
import domain.Login;
import domain.NonUser;
import domain.NonUserPayment;
import domain.UserPayment;

public class PaymentLisetView {

	private Scanner keyboard;

	public PaymentLisetView() {
		keyboard = new Scanner(System.in);

	}

	public void checkingUserOrNonUser() { //결제확인을 위한 회원인지 비회원인지 선택

		try {
			System.out.println("1. 회원");
			System.out.println("2. 비회원");

			int checkingNumber = keyboard.nextInt();

			switch (checkingNumber) {

			case 1:
				Controllers.getPaymentController().requestPaymentListLogin(checkingNumber);
				break;
			case 2:
				Controllers.getPaymentController().requestPaymentListLogin(checkingNumber);
				break;
			default:
				new AlertView().alert("[*] 메 뉴 를 다 시 선 택 해 주 세 요  [*]");

			}
		} catch (InputMismatchException e) {
			System.out.println("올바른 입력을 입력해주세요.");
			Controllers.getPaymentController().requestPaymentList();
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
	
	public void nonUserLogin() { //결제확인을 위한 비회원 로그인

		String nonUserName = null;
		String nonUserTel = null;
		
		System.out.println("[*] 비  회 원    [*] ");
		System.out.print("이   름 :");
		nonUserName = keyboard.next();
		System.out.print("전 화 번 호  :");
		nonUserTel = keyboard.next();
		
		NonUser newNonUser = new NonUser(nonUserName, nonUserTel);

		Controllers.getPaymentController().requestNonUserLoginProcessing(newNonUser);
	}


	public void userPaymentList(ArrayList<UserPayment> userPayments) { //회원결제목록 보기

		double sum = 0;
		System.out.println();
		System.out.println("[*]  결   제    내    역    정  보    조   회  [*]");
		System.out.println("        등급   별로   할인   적용           ");
		System.out.println();
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
			System.out.print(nonUserPayments.get(i).getNonUserTel() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderNumber() + "\t");
			System.out.print(nonUserPayments.get(i).getProductName() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderAmount() + "\t");
			System.out.print(nonUserPayments.get(i).getProudctPrice() + "\t");
			System.out.print(nonUserPayments.get(i).getOrderSum() + "\t");
			System.out.println(nonUserPayments.get(i).getPaymentDate());

			sum = sum + nonUserPayments.get(i).getOrderSum();
		}
		System.out.println("총 가격 : " + sum);
		Controllers.getMainController().requestMainView();
	}

}
