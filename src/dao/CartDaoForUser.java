package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controllers;
import domain.CartUser;
import repository.CartUserRepository;
import repository.LoginUserRepository;

public class CartDaoForUser {

	public CartDaoForUser() {
		new CartUserRepository();
	}
	// 0. 처음 로그인 시 DB에 있는 결제되지 않은 주문목록 장바구니로 불러오기
	public boolean loadCartList() {
		
		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int coupon = 0;
		int sum = 0;
		
		try {

			String sql = "select * from UserOrder_view_Infor where userId = ?";
			
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginUserRepository.getLogin().getLoginId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CartUser cart = new CartUser();
				CartUserRepository.setCartNumber(CartUserRepository.getCartNumber() + 1);
				cart.setCartNumber(CartUserRepository.getCartNumber());
				cart.setProductName(rs.getString(1));
				cart.setOrderAmount(rs.getInt(2));
				cart.setProductPrice(rs.getInt(3));
				cart.setCouponuseAmount(rs.getInt(4));
				cart.setProductPriceSum((rs.getInt(2) - rs.getInt(4)) * rs.getInt(3));
				CartUserRepository.getCart().add(cart);	
				
			}
			
			rs.close();
			pstmt.close();
			
			sql = "select u.coupon, d.className, d.discount  from user1 u, discount d where userId = ? and udiscountClassNumber = userClass";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginUserRepository.getLogin().getLoginId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				coupon = rs.getInt(1);
				CartUserRepository.setCoupon(coupon);
				CartUserRepository.setUserClass(rs.getString(2));
				for(int i = 0 ; i < CartUserRepository.getCart().size(); i++) {//총합산 계산
				sum = sum + CartUserRepository.getCart().get(i).getProductPriceSum();
				}
				CartUserRepository.setTotalPrice(sum * rs.getDouble(3));
			}
			success = true;

		} catch (SQLException e) { e.printStackTrace();
		} finally {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } 
			try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		return success; 
	}

	// 1. 장바구니 등록
	public boolean CartRegister(int productNumber, int orderCount) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartUser cart = new CartUser();

		String sql = "select productName, productPrice from product where productNumber = ?";
		try {
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, productNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 장바구니에 이미 담겨 있으면 수량만 증가
				for (int i = 0; i < CartUserRepository.getCart().size(); i++) {
					if (CartUserRepository.getCart().get(i).getProductName().equals(rs.getString(1))) {
						CartUserRepository.getCart().get(i)
						.setOrderAmount(CartUserRepository.getCart().get(i).getOrderAmount() + orderCount);
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

				CartUserRepository.setCartNumber(CartUserRepository.getCartNumber() + 1);
				cart.setCartNumber(CartUserRepository.getCartNumber());
				cart.setProductName(rs.getString(1));
				cart.setProductPrice(rs.getInt(2));
				cart.setOrderAmount(orderCount);
				CartUserRepository.getCart().add(cart);
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

	// 2. 장바구니 목록 (조회의 기능까지 포함 : 모든 정보 다 보여줄 것)
	public ArrayList<CartUser> selectCartList() {

		return CartUserRepository.getCart();

	}

	// 3. 장바구니 수정
	public boolean updateOrderAmount(int cartNumber, int updateOrderCount) {
		boolean success = false;

		for (int i = 0; i < CartUserRepository.getCart().size(); i++) {
			if (CartUserRepository.getCart().get(i).getCartNumber() == cartNumber) {
				CartUserRepository.getCart().get(i).setOrderAmount(updateOrderCount);
				break;
			}
		}
		success = true;
		return success;
	}

	// 4. 장바구니 비우기
	public boolean cartClear() {
		
		boolean success = false;

		new CartUserRepository();

		success = true;

		return success;
		
	}

	//5. 장바구니 삭제
	public boolean cartDeleteOne(int cartNumber) {
		boolean success = false;

		for(int i = 0; i < CartUserRepository.getCart().size(); i++) {
			if(cartNumber == CartUserRepository.getCart().get(i).getCartNumber()) {
				CartUserRepository.getCart().remove(i);
				break;
			}
		}

		success = true;

		return success;
	}

}
