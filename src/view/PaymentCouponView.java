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

	public void couponUseView(ArrayList<Cart> carts, int couponHonorablyAmount, String userClass, double totalPrice) { //쿠폰 사용한다고했을때 리스트나오기

		int sum = 0;
<<<<<<< HEAD
		System.out.println("\n   [*]  쿠  폰   사   용       가   능  목    록[*]\n");
=======
		System.out.println("할인율 실버 : 10% , 골드 : 15%, 플래티넘 : 20%");
		System.out.println("\n<쿠폰 사용 가능 목록>\n");
		System.out.println("현재 나의 등급 : " + userClass);
>>>>>>> refs/remotes/origin/master
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
			System.out.println(carts.get(i).getProductPriceSum());
			
		}
<<<<<<< HEAD
		System.out.println("[*]  총      금    액      [*]: " + sum);
		System.out.println("[*]  잔 여   쿠  폰   수 [*]: "+ couponHonorablyAmount/10 +"\n");
=======
		System.out.println("할인 된 총 금액 : " + totalPrice);
		System.out.println("남은 쿠폰 개수 : "+ couponHonorablyAmount/10 +"\n");
>>>>>>> refs/remotes/origin/master
		
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
