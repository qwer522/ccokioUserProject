package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controllers;
import domain.User;
import repository.LoginRepository;
import view.AlertView;

public class UserDao {

	public UserDao() {
		
	}
	
	public boolean userRegister(User newUser) { // 회원 가입 Dao

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			// ID 중복 체크
			String sql = "select * from User1 where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newUser.getUserId());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				new AlertView().alert("이미 아이디가 있습니다.");
				return success;
			}

			pstmt.close();
			// DB 테이블에 회원 데이터 삽입
			sql = "insert into User1(userNumber, userId, userPassword, userName, userTel, userAddress) values(User1_userNumber_seq.nextval, ?, ?, ?, ?, ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newUser.getUserId());
			pstmt.setString(2, newUser.getUserPassword());
			pstmt.setString(3, newUser.getUserName());
			pstmt.setString(4, newUser.getUserTel());
			pstmt.setString(5, newUser.getUserAddress());
		    result = pstmt.executeUpdate();

			if (result != 0) {
				success = true;
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
	
	public boolean userUpdate(User user) {

		boolean success = false;
		PreparedStatement pstmt = null;
		String sql = "update user1 set userpassword = ?, userTel = ?, userAddress = ? where userId = ?";

		try {
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUserPassword());
			pstmt.setString(2, user.getUserTel());
			pstmt.setString(3, user.getUserAddress());
			pstmt.setString(4, LoginRepository.getLogin().getLoginId());
			pstmt.executeUpdate();

			success = true;

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

		}

		return success;

	}

}
