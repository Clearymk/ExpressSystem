package application.view;

import application.dao.Select;
import application.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewFeedBackController {
	@FXML
	private TextField orderIDTextField;
	@FXML
	private TextField warehouseIDTextField;
	@FXML
	private TextField orderStateField;
	@FXML
	private TextArea remarkTextArea;

	private AlertUtil util = AlertUtil.getAlertUtil();
	private Select select = new Select();
	private FeatureController controller = FeatureController.getController();

	@FXML
	private void submitAction() {
		if (!isValidate()) {
			insert();
		}
	}

	private boolean isValidate() {
		String headMessage = "";
		String errorMessage = "";

		if (orderIDTextField.getText().length() == 0 || orderIDTextField.getText() == null) {
			errorMessage += "订单编号不能为空\n";
		}

		if (warehouseIDTextField.getText().length() == 0 || warehouseIDTextField.getText() == null) {
			errorMessage += "仓库编号不能为空\n";
		}

		if (orderStateField.getText().length() == 0 || orderStateField.getText() == null) {
			errorMessage += "订单状态不能为空\n";
		}

		if (remarkTextArea.getText().length() == 0 || remarkTextArea.getText() == null) {
			errorMessage += "备注不能为空\n";
		}

		if (errorMessage.length() == 0) {
			return false;
		} else {
			headMessage = "缺少信息";

			util.setHanderMessage(headMessage);
			util.setMessage(errorMessage);
			util.showMessage(AlertType.ERROR);

			return true;
		}
	}

	private void insert() {
		try {
			select.createViewFeedback(Integer.valueOf(orderIDTextField.getText()),
					Integer.valueOf(warehouseIDTextField.getText()), controller.getMainApp().getUserLogin().getId(), orderStateField.getText(),
					remarkTextArea.getText());
			
			util.setHanderMessage("提交成功");
			util.setMessage("检视单信息提交成功");
			util.showMessage(AlertType.INFORMATION);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			util.setHanderMessage("信息错误");
			util.setMessage("请重新填写");
			util.showMessage(AlertType.ERROR);
		}
	}
}
