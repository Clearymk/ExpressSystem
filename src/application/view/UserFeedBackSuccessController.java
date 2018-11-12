package application.view;

import javafx.fxml.FXML;

public class UserFeedBackSuccessController {
	private FeatureController controller = FeatureController.getController();
	
	@FXML
	private void close() {
		controller.getMainApp().killUserFeedBackSuccessStage();
	}
}
