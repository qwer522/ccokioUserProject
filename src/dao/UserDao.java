package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controllers;
import domain.User;
import view.AlertView;

public class UserDao {

	// 회원 가입 Dao
	public boolean userRegister(User newUser) {

		boolean success = false;
		PreparedStatement pstmt = null;
		// Statement stmt = null;
		ResultSet rs = null;
		int nextUserNumber = 0;
		int result = 0;

		try {
			// ID 중복 체크
			String sql = "select * from User1 where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newUser.getUserId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				new AlertView().alert("이미 아이디가 있습니다.");
				if (rs.wasNull()) { // 최초로 회원 가입할 때
					nextUserNumber = 1;
				}
			}

			newUser.setUserNumber(nextUserNumber);
			pstmt.close();
			// DB 테이블에 회원 데이터 삽입
			sql = "insert into User1 values(User1_userNumber_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newUser.getUserId());
			pstmt.setString(2, newUser.getUserPassword());
			pstmt.setString(3, newUser.getUserName());
			pstmt.setString(4, newUser.getUserTel());
			pstmt.setString(5, newUser.getUserAddress());
			pstmt.setInt(6, newUser.getUserClass());
			pstmt.setInt(7, newUser.getCoupon());
			pstmt.setInt(8, newUser.getPurchaseQuantity());

			result = pstmt.executeUpdate();

			if (result != 0) {
				success = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return success;

	}

}
