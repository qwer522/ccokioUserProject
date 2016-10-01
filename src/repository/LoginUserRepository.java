package repository;

import domain.Login;

public class LoginUserRepository {

	private static Login login;

	public LoginUserRepository() {

		login = null;
	}

	public static Login getLogin() {
		return login;
	}

	public static void setLogin(Login login) {
		LoginUserRepository.login = login;
	}

}
