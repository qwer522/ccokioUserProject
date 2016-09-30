package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.Product;

public class ProductDao {

	// 상품 목록 Dao
	public ArrayList<Product> productSelectList() {

		ArrayList<Product> products = new ArrayList<Product>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select * from system.Product";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Product product = new Product();
				product.setProductNumber(rs.getInt("productNumber"));
				product.setProductName(rs.getString("productName"));
				product.setProductCommant(rs.getString("productCommant"));
				product.setProductPrice(rs.getInt("productPrice"));
				product.setProductOrigin(rs.getString("productOrigin"));
				products.add(product);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return products;
	}

	// 존재하는 상품 번호인지 확인하는 Dao
	public boolean checkProductNumber(int selectedProductNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from product where productNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedProductNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;

	}

	// 상품 조회 Dao
	public Product productSelectOne(int searchProductNumber) {

		Product searchProduct = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from product where productNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchProductNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				searchProduct = new Product();
				searchProduct.setProductNumber(rs.getInt("productNumber"));
				searchProduct.setProductName(rs.getString("productName"));
				searchProduct.setProductCommant(rs.getString("productCommant"));
				searchProduct.setProductPrice(rs.getInt("productPrice"));
				searchProduct.setProductOrigin(rs.getString("productOrigin"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return searchProduct;

	}

}
