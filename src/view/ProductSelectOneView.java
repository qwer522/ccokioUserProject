package view;

import java.util.Scanner;

import controller.Controllers;
import domain.Product;

public class ProductSelectOneView {

	private Scanner keyboard;

	public ProductSelectOneView() {

		keyboard = new Scanner(System.in);

	}

	public void getSearchProductNumber() {

		int searchProductNumber = 0;

		System.out.println("\n[제품 조회 모드]");
		System.out.print("조회 할 제품번호 : ");
		searchProductNumber = keyboard.nextInt();

		Controllers.getProductController().requestReturnSelectOne(searchProductNumber);

	}

	public void productSelectOne(Product searchProduct) { //회원이 조회

		System.out.println("제품 번호 : " + searchProduct.getProductNumber());
		System.out.println("제품명 : " + searchProduct.getProductName());
		System.out.println("가   격 : " + searchProduct.getProductPrice());
		System.out.println("제품 설명 : " + searchProduct.getProductCommant());
		System.out.println("제 조 사 : " + searchProduct.getProductOrigin());

		Controllers.getLoginController().requsetCheckLogin(searchProduct);
	}
	
	public void nonUserProductSelectOne(Product searchProduct) { //비회원이 조회

		System.out.println("제품 번호 : " + searchProduct.getProductNumber());
		System.out.println("제품명 : " + searchProduct.getProductName());
		System.out.println("가   격 : " + searchProduct.getProductPrice());
		System.out.println("제품 설명 : " + searchProduct.getProductCommant());
		System.out.println("제 조 사 : " + searchProduct.getProductOrigin());

		Controllers.getProductController().requestNonUserSelectOneMenu(searchProduct);
	}

	public void productSelectOneMenu(Product searchProduct) {

		System.out.println();
		System.out.println("1. 장바구니에 담기");
		System.out.println("2. 뒤로가기");

		int prdocutSelectOneMainViewNumber = keyboard.nextInt();
		if (prdocutSelectOneMainViewNumber == 1) {
			Controllers.getCartController().requestCartRegister(searchProduct.getProductNumber());	// 장바구니에 담기 메서드 호출
		} else if (prdocutSelectOneMainViewNumber == 2) {
			Controllers.getMainController().requestUserMainView();
		} else {
			Controllers.getProductController().requestSelectOneMenu(searchProduct);
		}

	}
	
	public void nonUserProductSelectOneMenu(Product searchProduct) {

		System.out.println();
		System.out.println("1. 장바구니에 담기");
		System.out.println("2. 뒤로가기");

		int prdocutSelectOneMainViewNumber = keyboard.nextInt();
		if (prdocutSelectOneMainViewNumber == 1) {
//			Controllers.getCartController().requestNonUserCartRegister(searchProduct.getProductNumber());	// 장바구니에 담기 메서드 호출
		} else if (prdocutSelectOneMainViewNumber == 2) {
			Controllers.getMainController().requestNonUserMainView();
		} else {
			Controllers.getProductController().requestSelectOneMenu(searchProduct);
		}

	}

}
