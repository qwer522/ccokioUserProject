package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controllers;
import domain.Login;
import repository.LoginUserRepository;
import repository.LoginNonUserRepository;

public class LoginDao {

	public LoginDao() {

		new LoginUserRepository();

	}

	public boolean logIn(Login newLogin) {
		
		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//로그인 아이디 비밀번호 확인
			String sql = "select userId, userPassword from user1 where userId = ? and userPassword = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newLogin.getLoginId());
			pstmt.setString(2, newLogin.getLoginPassword());
			rs = pstmt.executeQuery();

			if(rs.next()) {
				LoginUserRepository.setLogin(newLogin);
				success = true;
			}else {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (SQLException e) {	e.printStackTrace();}
			}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			}
		}

		return success;

	}

	public boolean checkLogin() {
		
		boolean success = false;
		
		if (LoginUserRepository.getLogin() != null) {
			success = true;
		}

		return success;
	}
	
	public boolean logOut() {
		boolean success = false;
		
		LoginUserRepository.setLogin(null);
		success = true;
	
		return success;
	}
	
	public boolean nonUserLogOut() {
		boolean success = false;
		
		LoginNonUserRepository.setNonUsers(null);
		success = true;
	
		return success;
	}

}
