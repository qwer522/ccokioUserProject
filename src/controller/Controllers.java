package controller;

public class Controllers {

	private static ProgramController programController;
	private static MainController mainController;
	private static PaymentController paymentController;
	
	public Controllers() {

		mainController = new MainController();
		programController = new ProgramController();
		paymentController = new PaymentController();
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

}
