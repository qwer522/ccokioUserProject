	 package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controllers;

public class PaymentDao {

	public PaymentDao() {

	}

	public boolean register() { //결제 요청 처리

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		
		try {		

			Controllers.getProgramController().getConnection().setAutoCommit(false);
			
			String sql = " select userOrderNumber from UserOrder where userId = ? and paymentflag = 'n'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, "qwer522"); //로그인 레파지토이 아이디로 호출할것 qwer522는 대체로넣어놓은것
			rs = pstmt.executeQuery();
			
			//처음에만 뷰값증가시키기
			if(rs.next()) {
				
				sql = "insert into UserPayment(paymentNumber, orderNumber) values(payment4_paymentNumber_seq.nextval, ?)";
				pstmt1 = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt1.setInt(1, rs.getInt(1));
				pstmt1.executeUpdate();
			
			}
			//두번째부터 뷰값 현재값으로
			while(rs.next()) {
			
				sql = "insert into UserPayment(paymentNumber, orderNumber) values(payment4_paymentNumber_seq.currval, ?)";
				pstmt1 = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt1.setInt(1, rs.getInt(1));
				pstmt1.executeUpdate();
			
			}
			
			pstmt.close();
			
			sql = "update order4 set paymentflag = 'y' where paymentflag = 'n' and userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, "qwer522");
			pstmt.executeUpdate();
			
			Controllers.getProgramController().getConnection().commit();

		} catch (SQLException e) {
			System.out.println("결제 시 예외가 발생했습니다.");
			e.printStackTrace();

			try {Controllers.getProgramController().getConnection().rollback();} catch (SQLException e1) {e1.printStackTrace();	}

			return false;
		}finally {
			if(pstmt != null){
				try {pstmt.close();	} catch (SQLException e) {e.printStackTrace();}
			}
			if(rs != null){
				try {rs.close();	} catch (SQLException e) {e.printStackTrace();}
			}
			if(pstmt1 != null){
				try {pstmt1.close();	} catch (SQLException e) {e.printStackTrace();}
			}
			try {
				Controllers.getProgramController().getConnection().setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

//	public ArrayList<Payment> myPayment() { // 나의 결제내역 보여주기
//		
//		Payment myPayment = null ;
//		ArrayList<Payment> myPayments = new ArrayList<Payment>();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		
//		try {
//			
//			String sql = "select * from payment4_view_paymentInfor where userId = ?";
//			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
//			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				
//				myPayment = new Payment();
//				myPayment.setPaymentNumber(rs.getInt(1));
//				myPayment.setUserId(rs.getString(2));
//				myPayment.setOrderNumber(rs.getInt(3));
//				myPayment.setProductName(rs.getString(4));
//				myPayment.setOrderCount(rs.getInt(5));
//				myPayment.setOrderSum(rs.getInt(5) * rs.getInt(6));
//				myPayment.setPaymentDate(rs.getString(7));
//				myPayments.add(myPayment);
//				
//			}
//			
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			if(rs != null) {
//				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
//			}
//			if(pstmt != null) {
//				try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
//			}
//		}
//
//
//		return myPayments;
//	}

}