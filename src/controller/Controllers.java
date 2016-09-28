package controller;

public class Controllers {

	private static ProgramController programController;
	private static MainController mainController;
	private static PaymentController paymentController;
	private static LoginController loginController;
	private static UserController userController;
	private static NonUserController nonUserController;

	public Controllers() {
		loginController = new LoginController();
		mainController = new MainController();
		programController = new ProgramController();
		paymentController = new PaymentController();
		userController = new UserController();
		nonUserController = new NonUserController();
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

	public static UserController getUserController() {
		return userController;
	}

	public static NonUserController getNonUserController() {
		return nonUserController;
	}

}
