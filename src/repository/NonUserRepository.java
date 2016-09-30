package repository;

import domain.NonUser;

public class NonUserRepository {

	private static NonUser nonUsers;

	public NonUserRepository() {
		nonUsers = new NonUser();

	}

	public static NonUser getNonUsers() {
		return nonUsers;
	}

	public static void setNonUsers(NonUser nonUsers) {
		NonUserRepository.nonUsers = nonUsers;
	}

}
