package view;

import java.util.Scanner;

public class PaymentCouponView {

	private Scanner keyboard;

	public PaymentCouponView() {

		keyboard = new Scanner(System.in);

	}
	
	public void couponCheckingView(int userCoupon) {
		System.out.println("쿠폰을 사용하시 겠습니까?");
		System.out.println("1. 사용");
		System.out.println("2. 사용 안함");
		
		int coupon = keyboard.nextInt();
		
		if(coupon == 1) {
			
		}else if(coupon == 2) {
			
		}else {
			
		}
		
	}

}
