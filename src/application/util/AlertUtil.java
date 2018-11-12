package application.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertUtil {
	private static AlertUtil util = new AlertUtil();
	private String handerText = "";
	private String contextMessage = "";

	private AlertUtil() {

	}
	
	public static AlertUtil getAlertUtil() {
		return util;
	}

	public String getHanderText() {
		return handerText;
	}

	public void setHanderMessage(String handerText) {
		this.handerText = handerText;
	}

	public String getMessage() {
		return contextMessage;
	}

	public void setMessage(String message) {
		this.contextMessage = message;
	}

	public void showMessage(AlertType type) {
		if (contextMessage.length() != 0 && handerText.length() != 0) {
			Alert alert = new Alert(type);

			alert.setTitle(type.name() + "DIALOG");
			alert.setHeaderText(handerText);
			alert.setContentText(contextMessage);

			alert.showAndWait();
		}
	}
}
