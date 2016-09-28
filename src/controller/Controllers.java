package controller;

public class Controllers {

	private static ProgramController programController;
	private static MainController mainController;
	private static PaymentController paymentController;
	private static LoginController loginController;
<<<<<<< HEAD
	private static CartController cartController;
=======
	private static UserController userController;
	private static NonUserController nonUserController;
>>>>>>> refs/remotes/origin/master

	public Controllers() {
		loginController = new LoginController();
		mainController = new MainController();
		programController = new ProgramController();
		paymentController = new PaymentController();
<<<<<<< HEAD
		cartController = new CartController();
=======
		userController = new UserController();
		nonUserController = new NonUserController();
>>>>>>> refs/remotes/origin/master
	}

	public static LoginController getLoginController() {
		return loginController;
	}

	public static ProgramController getProgramController() {
		return programController;
	}

	public static MainController getMainController() {
		return mainController;
	}

	public static PaymentController getPaymentController() {
		return paymentController;
	}

<<<<<<< HEAD
	public static CartController getCartController() {
		return cartController;
=======
	public static UserController getUserController() {
		return userController;
	}

	public static NonUserController getNonUserController() {
		return nonUserController;
>>>>>>> refs/remotes/origin/master
	}

}
