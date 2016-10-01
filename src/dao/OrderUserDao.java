package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Controllers;
import repository.CartUserRepository;
import repository.LoginUserRepository;

public class OrderUserDao {

	public OrderUserDao() {

	}
	
	public boolean orderRegister() { //장바구니를 주문DB에 저장
		boolean success = false;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {	

			Controllers.getProgramController().getConnection().setAutoCommit(false);
			//			장바구니에 등록할때 주문테이블에 이미 있는 주문을 삭제한 후에  다시 등록 
			//			(장바구니에서 수정, 삭제, 등등은 카트 리포지토리에서만하고 주문 테이블에서는 결제만 수행)
			String sql = "delete from UserOrder where userOrderNumber in (select o.userOrderNumber"
					+ " from Product p, UserOrder o "
					+ "where o.productName = p.productName and ? = o.USERID and o.paymentflag = 'n')";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginUserRepository.getLogin().getLoginId());
			pstmt.executeUpdate();

			pstmt.close();
			for(int i = 0 ; i < CartUserRepository.getCart().size(); i++) {		
				
				sql = "insert into UserOrder(userOrderNumber, userId, productName, orderAmount) values(User1_orderNumber_seq.nextval, ?, ?, ?)";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setString(1, LoginUserRepository.getLogin().getLoginId());
				pstmt.setString(2, CartUserRepository.getCart().get(i).getProductName());
				pstmt.setInt(3, CartUserRepository.getCart().get(i).getOrderAmount());
				pstmt.executeUpdate();
				success = true;

			}

			Controllers.getProgramController().getConnection().commit();


		} catch (SQLException e) {
			System.out.println("주문 시 예외가 발생했습니다.");
			e.printStackTrace();

			try {
				Controllers.getProgramController().getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;

		}finally {
			if(rs != null){
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
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
