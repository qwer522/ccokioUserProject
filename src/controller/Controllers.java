package controller;

public class Controllers {

	private static ProgramController programController;
	private static MainController mainController;
	private static PaymentController paymentController;
	private static LoginController loginController;
	private static CartController cartController;

	public Controllers() {
		loginController = new LoginController();
		mainController = new MainController();
		programController = new ProgramController();
		paymentController = new PaymentController();
		cartController = new CartController();
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

	public static CartController getCartController() {
		return cartController;
	}

}
