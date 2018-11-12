package application.view;


import application.model.UserFunction;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UserFunctionController {
	@FXML
	private VBox userFunctionVBox;
	@FXML
	private HBox userFunctionHBox;
	
	private FeatureController controller = FeatureController.getController();

	@FXML
	private void selectView(Event e) {
		HBox selectHBox = (HBox) e.getSource();

		selectHBox.requestFocus();

		Label selectLabel = (Label)selectHBox.getChildren().get(0);
		
		for (UserFunction function : controller.getMainApp().getFunctionData()) {
			if(function.getFunctionCodeString().equals(selectLabel.getId())) {
				controller.getMainApp().loadSelectFunctionView(function.getFunctionCodeString());
			}		
		}
	}
}
