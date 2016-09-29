package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.Cart;

public class PaymentCouponView {

	private Scanner keyboard;

	public PaymentCouponView() {

		keyboard = new Scanner(System.in);

	}

	public void couponUseCheckingView() { //사용 할지 안할지 결정

		System.out.println("쿠폰을 사용하시 겠습니까?");
		System.out.println("1. 사용");
		System.out.println("2. 사용 안함");

		while(true) {

			int coupon = keyboard.nextInt();

			if(coupon == 1) {

			}else if(coupon == 2) {
				Controllers.getPaymentController().requestUserRegister();
			}else {

			}
		}
	}

	public void couponUseView(ArrayList<Cart> carts) { //쿠폰 사용 뷰

		int sum = 0;

		System.out.println("\n<쿠폰 사용 가능 목록>\n");
		System.out.println("번호   제품이름\t수량\t가격\t합계금액");

		if (carts.size() == 0) {
			System.out.println("\n장바구니가 비어있습니다.\n");
		}
		for (int i = 0; i < carts.size(); i++) {
			System.out.print(carts.get(i).getCartNumber() + "\t");
			System.out.print(carts.get(i).getProductName() + "\t");
			System.out.print(carts.get(i).getOrderAmount() + "\t");
			System.out.print(carts.get(i).getProductPrice() + "\t");
			System.out.println(carts.get(i).getOrderAmount() * carts.get(i).getProductPrice());

			sum = sum + (carts.get(i).getOrderAmount() * carts.get(i).getProductPrice());

			System.out.println("총 금액 : " + sum + "\n");
		}
		System.out.println("쿠폰 사용할 번호");
		int number = keyboard.nextInt();

		Controllers.getPaymentController().requestUserCouponUseNumber(number);
	}

}
