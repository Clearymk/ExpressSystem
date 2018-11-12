package application.view;

import application.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AutoTransferWeightController {
	@FXML
	private TextField lengthField;
	@FXML
	private TextField widthField;
	@FXML
	private TextField heightField;
	@FXML
	private Label weightLabel;

	private AlertUtil util = AlertUtil.getAlertUtil();

	@FXML
	private void clickTOTransferWeight() {
		try {
			double weight = (double) (Integer.parseInt(lengthField.getText()) * Integer.parseInt(widthField.getText())
					* Integer.parseInt(heightField.getText())) / 6000;

			weight = (double) ((int) (weight * 100)) / 100;

			weightLabel.setText(String.valueOf(weight));
		} catch (NumberFormatException e) {
			util.setHanderMessage("无法转换");
			util.setMessage("输入错误的数字！请重新输入");
			util.showMessage(AlertType.ERROR);
		}
	}

}
