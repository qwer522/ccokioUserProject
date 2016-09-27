package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProgramController {

	private Connection connection;

	public ProgramController() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "1234");


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		return connection;

	}
	
	public void requestCloseConnection() {
		if(connection != null) {
			try { connection.close(); } catch(SQLException e) { e.printStackTrace();} 
		}
	}


	public void requestExitProgram() {

		if(connection != null) {
			try { connection.close(); } catch(SQLException e) { e.printStackTrace();} 
		}

		System.out.println("프로그램이 종료되었습니다.");
		System.exit(0);

	}
}
