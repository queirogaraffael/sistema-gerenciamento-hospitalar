package hospitalManagementSystem.application;

import hospitalManagementSystem.controller.HospitalManagerController;

public class Main {
	public static void main(String[] args) {

		HospitalManagerController mainController = new HospitalManagerController();
		mainController.menuPrincipal();
	}
}