package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controllers;
import domain.Login;
import repository.LoginRepository;
import view.AlertView;

public class LoginDao {

	public LoginDao() {

		new LoginRepository();

	}

	public boolean logIn(Login newLogin) {
		
		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			String sql = "select * from user1 where userId = ? and userPassword = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newLogin.getLoginId());
			pstmt.setString(2, newLogin.getLoginPassword());
			rs = pstmt.executeQuery();

			if (rs != null) {
				
				LoginRepository.setLogin(newLogin);
				success = true;
			}

		} catch (SQLException e) {
			new AlertView().alert("아이디나 비밀번호가 틀렸습니다.");
			e.printStackTrace();
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
		}

		return success;

	}

	public boolean checkLogin() {
		
		boolean success = false;
		
		if (LoginRepository.getLogin() != null) {
			
			success = true;
		}

		return success;
	}
	
	public static void logOut(){
		
		LoginRepository.setLogin(null);
	}

}
