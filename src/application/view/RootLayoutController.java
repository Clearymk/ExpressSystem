package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class RootLayoutController {
	@FXML
	private Menu fileMenu;
	@FXML
	private MenuItem exitMenuItem;
	@FXML
	private MenuItem aboutMenuItem;
	
	private FeatureController controller = FeatureController.getController();

	@FXML
	private void exitAction() {
		controller.getMainApp().killPrimaryStage();
	}

	@FXML
	private void aboutMenuItem() {
		controller.getMainApp().showAboutDialog();
	}
}
