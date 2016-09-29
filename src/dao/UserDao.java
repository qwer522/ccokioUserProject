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
			sql = "insert into User1(userNumber, userId, userPassword, userName, userTel, userAddress, userClass) values(User1_userNumber_seq.nextval, ?, ?, ?, ?, ?, 1)";
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
	public boolean UserDelete() { // 삭제

		boolean success = false;

		PreparedStatement pstmt = null;
		String sql = "delete user1 where userId = ?";

		try {

			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
			pstmt.executeUpdate();
			
			LoginRepository.setLogin(null);
			
			success = true;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return success;

	}
	
	public User UserLoginInfo() {

		User searchedUser = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userClass = null;
		try {
			String sql = "select userName, userTel, userAddress, userClass, Coupon, purchaseQuantity from user1 where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				searchedUser = new User();
				searchedUser.setUserName(rs.getString(1));
				searchedUser.setUserTel(rs.getString(2));
				searchedUser.setUserAddress(rs.getString(3));

				if(rs.getInt(4) == 1){
					userClass = "실버";
				}else if(rs.getInt(4) == 2) {
					userClass = "골드";
				}else {
					userClass = "플래티넘";
				}
				
				searchedUser.setUserClass(userClass);
				searchedUser.setCoupon(rs.getInt(5));
				searchedUser.setPurchaseQuantity(rs.getInt(6));
			}
		} catch (SQLException e) {
			System.out.println("유저 보기 에서 예외가 발생함.");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}			
		}		

		return searchedUser;

	}

}
