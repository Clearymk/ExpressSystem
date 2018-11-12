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
			errorMessage += "������Ų���Ϊ��\n";
		}

		if (warehouseIDTextField.getText().length() == 0 || warehouseIDTextField.getText() == null) {
			errorMessage += "�ֿ��Ų���Ϊ��\n";
		}

		if (orderStateField.getText().length() == 0 || orderStateField.getText() == null) {
			errorMessage += "����״̬����Ϊ��\n";
		}

		if (remarkTextArea.getText().length() == 0 || remarkTextArea.getText() == null) {
			errorMessage += "��ע����Ϊ��\n";
		}

		if (errorMessage.length() == 0) {
			return false;
		} else {
			headMessage = "ȱ����Ϣ";

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
			
			util.setHanderMessage("�ύ�ɹ�");
			util.setMessage("���ӵ���Ϣ�ύ�ɹ�");
			util.showMessage(AlertType.INFORMATION);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			util.setHanderMessage("��Ϣ����");
			util.setMessage("��������д");
			util.showMessage(AlertType.ERROR);
		}
	}
}
