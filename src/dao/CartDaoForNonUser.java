package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controllers;
import domain.CartNonUser;
import repository.CartNonUserRepository;
import repository.NonUserRepository;

public class CartDaoForNonUser {

	public CartDaoForNonUser() {

		new CartNonUserRepository();

	}
//0. 비회원 접속 시 db 읽어오기
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

	public boolean cartNonUserClear() {//장바구니 초기화

		boolean success = false;

		new CartNonUserRepository();

		success = true;

		return success;

	}

	//1. 장바구니 등록
	public boolean cartNonUserRegister(int productNumber, int orderCount) {
		boolean success = false;


		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartNonUser cart = new CartNonUser();

		String sql = "select productName, productPrice from product where productNumber = ?";
		try {
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, productNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 장바구니에 이미 담겨 있으면 수량만 증가
				for (int i = 0; i < CartNonUserRepository.getCartNonUsers().size(); i++) {
					if (CartNonUserRepository.getCartNonUsers().get(i).getProductName().equals(rs.getString(1))) {
						CartNonUserRepository.getCartNonUsers().get(i)
						.setOrderAmount(CartNonUserRepository.getCartNonUsers().get(i).getOrderAmount() + orderCount);
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
						success = true;
						return success;

					}
				}

				CartNonUserRepository.setCartLastNumber(CartNonUserRepository.getCartLastNumber() + 1);
				cart.setCartNumber(CartNonUserRepository.getCartLastNumber());
				cart.setProductName(rs.getString(1));
				cart.setProductPrice(rs.getInt(2));
				cart.setOrderAmount(orderCount);
				CartNonUserRepository.getCartNonUsers().add(cart);
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) { try {rs.close();} catch (SQLException e) { e.printStackTrace();}}
		}	
		if (pstmt != null) { try {pstmt.close();} catch (SQLException e) { e.printStackTrace();}}


		return success;

	}

	//2. 장바구니 목록 (조회의 기능까지 포함 : 모든 정보 다 보여줄 것)
	public ArrayList<CartNonUser> selectCartNonUserList() {

		return CartNonUserRepository.getCartNonUsers();

	}


	//3. 장바구니  수정
	public boolean nonUserUpdateOrderAmount(int cartNumber, int updateOrderCount) {
		boolean success = false;

		for (int i = 0; i < CartNonUserRepository.getCartNonUsers().size(); i++) {
			if (CartNonUserRepository.getCartNonUsers().get(i).getCartNumber() == cartNumber) {
				CartNonUserRepository.getCartNonUsers().get(i).setOrderAmount(updateOrderCount);
				break;
			}
		}
		success = true;
		return success;
	}
	//4. 장바구니 삭제
	public boolean cartNonUserDeleteOne(int cartNumber) {
		boolean success = false;

		for(int i = 0; i < CartNonUserRepository.getCartNonUsers().size(); i++) {
			if(cartNumber == CartNonUserRepository.getCartNonUsers().get(i).getCartNumber()) {
				CartNonUserRepository.getCartNonUsers().remove(i);
				break;
			}
		}

		success = true;

		return success;
	}
}

