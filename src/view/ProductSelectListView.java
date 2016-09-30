package view;

import java.util.ArrayList;

import domain.Product;

public class ProductSelectListView {

	public void productListAll(ArrayList<Product> products) {

		System.out.println("\n[상품 목록 모드]");
		System.out.println("상품 번호\t상품 이름\t상품 설명\t상품 가격\t제조사");
		if (products.size() == 0) {
			System.out.println("등록된 제품이 없습니다.");
		} else {
			for (int i = 0; i < products.size(); i++) {
				System.out.print(products.get(i).getProductNumber() + "\t");
				System.out.print(products.get(i).getProductName() + "\t");
				System.out.print(products.get(i).getProductCommant() + "\t");
				System.out.print(products.get(i).getProductPrice() + "\t");
				System.out.println(products.get(i).getProductOrigin());
			}
		}
	}

	public void productList(ArrayList<Product> products) {

		System.out.println("\n[상품 목록 모드]");
		System.out.println("상품 번호\t상품 이름\t상품 가격\t제조사");
		if (products.size() == 0) {
			System.out.println("등록된 제품이 없습니다.");
		} else {
			for (int i = 0; i < products.size(); i++) {
				System.out.print(products.get(i).getProductNumber() + "\t");
				System.out.print(products.get(i).getProductName() + "\t");
				System.out.print(products.get(i).getProductPrice() + "\t");
				System.out.println(products.get(i).getProductOrigin());
			}
		}
	}

}
