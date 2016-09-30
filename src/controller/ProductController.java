package controller;

import java.util.ArrayList;

import dao.ProductDao;
import domain.Product;
import view.AlertView;
import view.ProductSelectListView;
import view.ProductSelectOneView;

public class ProductController {

	private ProductDao productDao;

	public ProductController() {

		this.productDao = new ProductDao();

	}

	// 상품 목록
	public void requestProductSelectList() {

		ArrayList<Product> products = productDao.productSelectList();

		ProductSelectListView productSelectListView = new ProductSelectListView();
		productSelectListView.productList(products);
	}

	// 상품 목록 All
	public void requestProductSelectListAll() {

		ArrayList<Product> products = productDao.productSelectList();

		ProductSelectListView productSelectListView = new ProductSelectListView();
		productSelectListView.productListAll(products);
	}

	// 상품 조회 요청
	public void requestProductSelectOne() {

		ProductSelectOneView productSelectOneView = new ProductSelectOneView();
		productSelectOneView.getSearchProductNumber();

	}

	// 상품 조회 요청
	public void requestReturnSelectOne(int searchProductNumber) {
		// 존재하는 상품 번호인지 확인 Dao
		boolean success = productDao.checkProductNumber(searchProductNumber);

		if (success) {
			// 상품 정보 조회 Dao
			Product searchProduct = productDao.productSelectOne(searchProductNumber);
			ProductSelectOneView productSelectOneView = new ProductSelectOneView();
			productSelectOneView.productSelectOne(searchProduct);

		} else {
			new AlertView().alert("존재하지 않는 상품입니다.");
			Controllers.getMainController().requestMainView(); // 메인으로

		}

	}

	// 상품 조회 후 메뉴 요청
	public void requestSelectOneMenu(Product searchProduct) {

		ProductSelectOneView productSelectOneView = new ProductSelectOneView();
		productSelectOneView.productSelectOneMenu(searchProduct);

	}

	// 비회원 상품 조회 요청
	public void requestNonUserProductSelectOne() {

		ProductSelectOneView productSelectOneView = new ProductSelectOneView();
		productSelectOneView.getNonUserSearchProductNumber();

	}

	// 비회원 상품 조회 요청
	public void requestNonUserReturnSelectOne(int searchProductNumber) {
		// 존재하는 상품 번호인지 확인 Dao
		boolean success = productDao.checkProductNumber(searchProductNumber);

		if (success) {
			// 상품 정보 조회 Dao
			Product searchProduct = productDao.productSelectOne(searchProductNumber);
			ProductSelectOneView productSelectOneView = new ProductSelectOneView();
			productSelectOneView.nonUserProductSelectOne(searchProduct);

		} else {
			new AlertView().alert("존재하지 않는 상품입니다.");
			Controllers.getMainController().requestMainView(); // 메인으로

		}

	}

	// 비회원 상품 조회 후 메뉴 요청
	public void requestNonUserSelectOneMenu(Product searchProduct) {

		ProductSelectOneView productSelectOneView = new ProductSelectOneView();
		productSelectOneView.nonUserProductSelectOneMenu(searchProduct);

	}

}
