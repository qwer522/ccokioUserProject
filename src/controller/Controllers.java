package controller;

public class Controllers {

	private static ProgramController programController;
	private static MainController mainController;
	private static PaymentController paymentController;
	private static LoginController loginController;
	private static CartUserController cartController;
	private static UserController userController;
	private static NonUserController nonUserController;
	private static ProductController productController;
	private static OrderUserController orderUserController;
	private static OrderNonUserController orderNonUserController;
	private static CartNonUserController cartNonUserController;
	
	public Controllers() {
		loginController = new LoginController();
		mainController = new MainController();
		programController = new ProgramController();
		paymentController = new PaymentController();
		cartController = new CartUserController();
		userController = new UserController();
		nonUserController = new NonUserController();
		productController = new ProductController();
		orderUserController = new OrderUserController();
		orderNonUserController = new OrderNonUserController();
		cartNonUserController = new CartNonUserController();
	}

	public static CartNonUserController getCartNonUserController() {
		return cartNonUserController;
	}

	public static OrderUserController getOrderUserController() {
		return orderUserController;
	}

	public static OrderNonUserController getOrderNonUserController() {
		return orderNonUserController;
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

	public static CartUserController getCartController() {
		return cartController;
	}
	public static UserController getUserController() {
		return userController;
	}

	public static NonUserController getNonUserController() {
		return nonUserController;
	}

	public static ProductController getProductController() {
		return productController;
	}

}
