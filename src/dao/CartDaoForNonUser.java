package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controllers;
import domain.CartNonUser;
import repository.CartNonUserRepository;
import repository.NonUserRepository;

public class CartDaoForNonUser {

	public CartDaoForNonUser() {

		new CartNonUserRepository();

	}

	public boolean loadCartNonUserList() { //비회원 주문 했을시 DB읽어오기

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from NonUserOrder_view_Infor where nonUserTel = ?";

			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, NonUserRepository.getNonUsers().getNonUserTel());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CartNonUser cartNonUsers = new CartNonUser();
				CartNonUserRepository.setCartLastNumber(CartNonUserRepository.getCartLastNumber() + 1);
				cartNonUsers.setCartNumber(CartNonUserRepository.getCartLastNumber());
				cartNonUsers.setProductName(rs.getString(1));
				cartNonUsers.setOrderAmount(rs.getInt(2));
				cartNonUsers.setProductPrice(rs.getInt(3));
				cartNonUsers.setProductPriceSum(rs.getInt(4));
				CartNonUserRepository.getCartNonUsers().add(cartNonUsers);

			}

			success = true;

		} catch (SQLException e) { e.printStackTrace();
		} finally {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } 
			try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		return success; 
	}

	public boolean cartClear() {//장바구니 초기화

		boolean success = false;

		new CartNonUserRepository();

		success = true;

		return success;

	}

	//1. 장바구니 등록
	public boolean CartRegister(int selectMenu) {
		boolean success = false;


		return success;

	}

	//2. 장바구니 목록 (조회의 기능까지 포함 : 모든 정보 다 보여줄 것)

	//3. 장바구니  수정

	//4. 장바구니 삭제
}

