package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controllers;
import domain.Cart;
import repository.CartRepository;
import repository.LoginRepository;

public class CartDaoForUser {

	public CartDaoForUser() {
		new CartRepository();
	}
	// 0. 처음 로그인 시 DB에 있는 결제되지 않은 주문목록 장바구니로 불러오기
	public boolean loadCartList() {
		
		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int coupon = 0;
		try {

			String sql = "select p.productName, o.orderAmount, p.productPrice, o.couponuseAmount from product p, userOrder o where o.userId = ? and o.productName = p.productName and o.paymentflag = 'n'";
			
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cart cart = new Cart();
				CartRepository.setCartNumber(CartRepository.getCartNumber() + 1);
				cart.setCartNumber(CartRepository.getCartNumber());
				cart.setProductName(rs.getString(1));
				cart.setOrderAmount(rs.getInt(2));
				cart.setProductPrice(rs.getInt(3));
				cart.setCouponuseAmount(rs.getInt(4));
				CartRepository.getCart().add(cart);	
				
			}
			
			rs.close();
			pstmt.close();
			
			sql = "select coupon from user1 where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				coupon = rs.getInt(1);
				CartRepository.setCoupon(coupon);
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
		Cart cart = new Cart();

		String sql = "select productName, productPrice from product where productNumber = ?";
		try {
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, productNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 장바구니에 이미 담겨 있으면 수량만 증가
				for (int i = 0; i < CartRepository.getCart().size(); i++) {
					if (CartRepository.getCart().get(i).getProductName().equals(rs.getString(1))) {
						CartRepository.getCart().get(i)
						.setOrderAmount(CartRepository.getCart().get(i).getOrderAmount() + orderCount);
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

				CartRepository.setCartNumber(CartRepository.getCartNumber() + 1);
				cart.setCartNumber(CartRepository.getCartNumber());
				cart.setProductName(rs.getString(1));
				cart.setProductPrice(rs.getInt(2));
				cart.setOrderAmount(orderCount);
				CartRepository.getCart().add(cart);
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
	public ArrayList<Cart> selectCartList() {

		return CartRepository.getCart();

	}

	// 3. 장바구니 수정
	public boolean updateOrderAmount(int cartNumber, int updateOrderCount) {
		boolean success = false;

		for (int i = 0; i < CartRepository.getCart().size(); i++) {
			if (CartRepository.getCart().get(i).getCartNumber() == cartNumber) {
				CartRepository.getCart().get(i).setOrderAmount(updateOrderCount);
				break;
			}
		}
		success = true;
		return success;
	}

	// 4. 장바구니 비우기
	public boolean cartClear() {
		boolean success = false;

		new CartRepository();

		success = true;

		return success;
	}

	//5. 장바구니 삭제
	public boolean cartDeleteOne(int cartNumber) {
		boolean success = false;

		for(int i = 0; i < CartRepository.getCart().size(); i++) {
			if(cartNumber == CartRepository.getCart().get(i).getCartNumber()) {
				CartRepository.getCart().remove(i);
				break;
			}
		}

		success = true;

		return success;
	}

}
