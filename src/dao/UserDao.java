package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.Controllers;
import domain.User;
import repository.LoginRepository;

public class UserDao {

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

	// public boolean userDelete(int searchUserNumer) {
	//
	// boolean success = false;
	// PreparedStatement pstmt = null;
	// int result = 0;
	//
	// try {
	//
	// String sql = "delete from system.user1 where userNumber = ?";
	// pstmt =
	// Controllers.getProgramController().getConnection().prepareStatement(sql);
	// pstmt.setInt(1, searchUserNumer);
	// result = pstmt.executeUpdate();
	//
	// if(result != 0) {
	// success = true;
	// }
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// if(pstmt != null) {
	// try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
	// }
	// }
	//
	// return success;
}
