package repository;

import java.util.ArrayList;

import domain.NonUser;

public class NonUserRepository {

	private static ArrayList<NonUser> nonUsers;

	public NonUserRepository() {
		nonUsers = new ArrayList<NonUser>();

	}

	public static ArrayList<NonUser> getNonUsers() {
		return nonUsers;
	}

	public static void setNonUsers(ArrayList<NonUser> nonUsers) {
		NonUserRepository.nonUsers = nonUsers;
	}

}
