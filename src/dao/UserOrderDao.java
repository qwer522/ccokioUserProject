package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controllers;
import domain.Order;
import repository.CartRepository;
import repository.LoginRepository;

public class UserOrderDao {

	public UserOrderDao() {

	}

	// 1. 주문 등록
	public boolean orderRegister() {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Controllers.getProgramController().getConnection().setAutoCommit(false);
			String sql = "delete from userOrder where orderNumber in (select o.orderNumber"
					+ " from product p, userOrder o "
					+ "where o.productName = p.productName and o.userId = ? and o.paymentflag = 'n')";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
			pstmt.executeUpdate();

			for (int i = 0; i < CartRepository.getCart().size(); i++) {

				sql = "insert into userOrder(userOrderNumber, userId, productName, "
						+ "orderAmount) values(User1_orderNumber_seq.nextval,?,?,?) ";
				pstmt.setString(1, LoginRepository.getLogin().getLoginId());
				pstmt.setString(2, CartRepository.getCart().get(i).getProductName());
				pstmt.setInt(3, CartRepository.getCart().get(i).getOrderAmount());
				pstmt.executeUpdate();
				success = true;

			}

		} catch (SQLException e) {
			System.out.println("주문 시 예외가 발생했습니다.");
			e.printStackTrace();

			try {
				Controllers.getProgramController().getConnection().rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			return false;

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
			try {
				Controllers.getProgramController().getConnection().setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}

	// 2. 주문 목록 불러오기
	public ArrayList<Order> OrderSelectList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order> orderList = new ArrayList<Order>();

		try {
			String sql = "select o.userOrderNumber, p.productName, p.productPrice, o.orderAmount "
					+ "from product p, userOrder o "
					+ "where u.userId = ? and p.productName = o.userOrderName and o.paymentflag ='n'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Order order = new Order();
				order.setUserOrderNumber(rs.getInt(1));
				order.setProductName(rs.getString(2));
				order.setProductPrice(rs.getInt(3));
				order.setOrderAmount(rs.getInt(4));
				orderList.add(order);

			}

		} catch (SQLException e) {
			System.out.println("주문목록 보기에서 예외 발생");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

		return orderList;
	}

	// 3. 주문 수정
	public boolean orderUpdate(int selectOrderNumber, int updateOrderAmount) {

		boolean success = false;
		PreparedStatement pstmt = null;

		try {
			String sql = "update userOrder set orderAmount = ? where userOrderNumber = ? and userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, updateOrderAmount);
			pstmt.setInt(2, selectOrderNumber);
			pstmt.setString(3, LoginRepository.getLogin().getLoginId());
			pstmt.executeUpdate();
			success = true;

		} catch (SQLException e) {
			System.out.println("주문 수량 수정에서 예외가 발생하였습니다.");
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return success;
	}

	// 4. 주문 취소
	public boolean orderDelete(int selectOrderNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;

		try {
			Controllers.getProgramController().getConnection().setAutoCommit(false);
			
			String sql = "delete userOrder where userOrderNumber = ? and userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectOrderNumber);
			pstmt.setString(2, LoginRepository.getLogin().getLoginId());
			pstmt.executeUpdate();
			success = true;

		} catch (SQLException e) {
			System.out.println("주문 수량 수정에서 예외가 발생하였습니다.");
			e.printStackTrace();

			try {
				Controllers.getProgramController().getConnection().rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			return false;

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				Controllers.getProgramController().getConnection().setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
}
