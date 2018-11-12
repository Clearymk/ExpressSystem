package application.view;

import application.MainApp;

public class FeatureController {
	private static FeatureController controller = new FeatureController();
	private MainApp mainApp;
			

	private FeatureController() {
		
	}
	
	public static FeatureController getController() {
		return controller;
	}
	
	public MainApp getMainApp() {
		return mainApp;
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
