package controller;

public class Controllers {

	private static ProgramController programController;
	private static MainController mainController;
	private static PaymentController paymentController;
	private static LoginController loginController;
	private static UserCartController userCartController;
	private static UserController userController;
	private static NonUserController nonUserController;
	private static UserOrderController userOrderController;

	public Controllers() {
		loginController = new LoginController();
		mainController = new MainController();
		programController = new ProgramController();
		paymentController = new PaymentController();
		userCartController = new UserCartController();
		userController = new UserController();
		nonUserController = new NonUserController();
		userOrderController = new UserOrderController();
	
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

	public static UserCartController getCartController() {
		return userCartController;
	}
	public static UserController getUserController() {
		return userController;
	}

	public static NonUserController getNonUserController() {
		return nonUserController;
	}

	public static UserOrderController getUserOrderController() {
		return userOrderController;
	}

}
