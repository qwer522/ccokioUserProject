package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controllers;
import domain.Product;

public class ProductSelectOneView {

	private Scanner keyboard;

	public ProductSelectOneView() {

		keyboard = new Scanner(System.in);

	}

	public void getSearchProductNumber() { //회원이 조회

		int searchProductNumber = 0;

		try {
			System.out.println("\n[제품 조회 모드]");
			System.out.print("조회 할 제품번호 : ");
			searchProductNumber = keyboard.nextInt();

			Controllers.getProductController().requestReturnSelectOne(searchProductNumber);
		} catch (InputMismatchException e) {
			System.out.println("올바른 입력을 입력해주세요.");
			Controllers.getProductController().requestProductSelectOne();
		}
		

	}
	
	public void getNonUserSearchProductNumber() { //비회원이 조회

		int searchProductNumber = 0;

		try {
			System.out.println("\n[제품 조회 모드]");
			System.out.print("조회 할 제품번호 : ");
			searchProductNumber = keyboard.nextInt();

			Controllers.getProductController().requestNonUserReturnSelectOne(searchProductNumber);
		} catch (InputMismatchException e) {
			System.out.println("올바른 입력을 입력해주세요.");
			Controllers.getProductController().requestNonUserProductSelectOne();
		}
		

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

		Controllers.getProductController().requestNonUserSelectOneMenu(searchProduct.getProductNumber());
	}

	public void productSelectOneMenu(Product searchProduct) {

		try {
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
		} catch (InputMismatchException e) {
			System.out.println("올바른 입력을 입력해주세요.");
			Controllers.getProductController().requestSelectOneMenu(searchProduct);
		}
		

	}
	
	public void nonUserProductSelectOneMenu(int searchProduct) { //비회원 상품 장바구니

		try {
			System.out.println();
			System.out.println("1. 장바구니에 담기");
			System.out.println("2. 뒤로가기");

			int prdocutSelectOneMainViewNumber = keyboard.nextInt();
			if (prdocutSelectOneMainViewNumber == 1) {
				Controllers.getCartNonUserController().requestCartNonUserRegister(searchProduct); // 장바구니에 담기 메서드 호출
			} else if (prdocutSelectOneMainViewNumber == 2) {
				Controllers.getMainController().requestNonUserMainView();
			} else {
				Controllers.getProductController().requestNonUserSelectOneMenu(searchProduct);
			}
		} catch (InputMismatchException e) {
			System.out.println("올바른 입력을 입력해주세요.");

			Controllers.getProductController().requestNonUserSelectOneMenu(searchProduct);
		}
		

	}

}
