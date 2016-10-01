package repository;

import domain.NonUser;

public class LoginNonUserRepository {

	private static NonUser nonUsers;

	public LoginNonUserRepository() {
		nonUsers = new NonUser();

	}

	public static NonUser getNonUsers() {
		return nonUsers;
	}

	public static void setNonUsers(NonUser nonUsers) {
		LoginNonUserRepository.nonUsers = nonUsers;
	}

}
