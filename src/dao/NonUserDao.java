package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controllers;
import domain.NonUser;
import repository.NonUserRepository;

public class NonUserDao {

	public NonUserDao() {

		new NonUserRepository();

	}

	// 비회원 등록 Dao
	public boolean nonUserRegister(NonUser newNonUser) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// DB 테이블에 비회원 데이터 삽입
			String sql = "insert into NonUser values(NonUser_NonUserNumber_seq.nextval, ?, ?, ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newNonUser.getNonUserName());
			pstmt.setString(2, newNonUser.getNonUserTel());
			pstmt.setString(3, newNonUser.getNonUserAddress());
			
			// 메모리(repository)에 비회원 데이터 삽입 
			pstmt.executeUpdate();
			NonUserRepository.setNonUsers(newNonUser);
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
	
	public boolean nonUserLogIn(NonUser newNonUser) { //비회원 로그인확인

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//로그인 아이디 비밀번호 확인
			String sql = "select * from NonUser where nonUserName = ? and nonUserTel = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newNonUser.getNonUserName());
			pstmt.setString(2, newNonUser.getNonUserTel());
			rs = pstmt.executeQuery();

			if(rs.next()) {
				NonUserRepository.setNonUsers(newNonUser);
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
}
