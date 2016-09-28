package view;

import java.util.ArrayList;
import controller.Controllers;
import domain.Cart;

public class CartListView {

	public CartListView() {

	}

	public void printCartList(ArrayList<Cart> carts) {

		int sum = 0;

		System.out.println("\n<장바구니 목록>\n");
		System.out.println("장바구니번호   제품이름\t주문수량\t가격\t합계금액");

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
		Controllers.getMainController().requestUserCartView();

	}

}
