package main;

import controller.Controllers;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();
		
		Controllers.getMainController().requestMainView();

	}

}
