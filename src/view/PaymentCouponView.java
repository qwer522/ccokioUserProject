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

	public void couponUseView(ArrayList<Cart> carts, int couponHonorablyAmount) { //쿠폰 사용한다고했을때 리스트나오기

		int sum = 0;
		System.out.println("\n   [*]  쿠  폰   사   용       가   능  목    록[*]\n");
		System.out.println("번호   제품이름\t수량\t사용된쿠폰개수\t가격\t합계금액");

		if (carts.size() == 0) {
			System.out.println("\n[*]  장  바  구니  가   비  어  있  습  니  다  [*]\n");
		}
		
		for (int i = 0; i < carts.size(); i++) {
			System.out.print(carts.get(i).getCartNumber() + "\t");
			System.out.print(carts.get(i).getProductName() + "\t");
			System.out.print(carts.get(i).getOrderAmount() + "\t");
			System.out.print(carts.get(i).getCouponuseAmount() + "\t\t");
			System.out.print(carts.get(i).getProductPrice() + "\t");
			System.out.println((carts.get(i).getOrderAmount()-carts.get(i).getCouponuseAmount()) * carts.get(i).getProductPrice());
			

			sum = sum + ((carts.get(i).getOrderAmount()-carts.get(i).getCouponuseAmount()) * carts.get(i).getProductPrice());

		}
		System.out.println("[*]  총      금    액      [*]: " + sum);
		System.out.println("[*]  잔 여   쿠  폰   수 [*]: "+ couponHonorablyAmount/10 +"\n");
		
		while(true) {
			System.out.println("[1] 쿠   폰     사   용");
			System.out.println("[2] 최   종     결   제");
			int number = keyboard.nextInt();

			if(number == 1) {
				System.out.println("쿠폰 사용할 번호 : ");
				int couponuseNumber = keyboard.nextInt();
				Controllers.getPaymentController().requestCouponUseNumber(couponuseNumber);
			}else if(number == 2) {
				Controllers.getPaymentController().requestUserRegisterProcessing();
			}else {

			}
		}
		
	}
	
	public void couponAmountUseView(int couponuseNumber) { // 쿠폰 사용번호까지입력후 쿠폰 몇개사용할지 뷰

		System.out.println("[*]  쿠   폰      사   용    개     수   [*] : ");
		int couponuseAmount = keyboard.nextInt();
		
		Controllers.getPaymentController().requestUseCouponAmount(couponuseAmount, couponuseNumber);
	}

}
