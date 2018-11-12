package application.view;

import application.dao.Select;
import application.model.UserFeedBackForm;
import application.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UserFeedBackController {
	@FXML
	private TextField orderIDTextField;
	@FXML
	private ChoiceBox<String> feedBackTypeChoiceBox;
	@FXML
	private TextField feedBackThemeTextField;
	@FXML
	private TextArea feedBackContentTextArea;

	private AlertUtil util = AlertUtil.getAlertUtil();
	private FeatureController controller = FeatureController.getController();
	private Select select = new Select();

	@FXML
	private void initialize() {
		feedBackTypeChoiceBox.getItems().addAll("����", "����", "����");
	}

	@FXML
	private void submitController() {
		if (isInputVaild()) {
			util.showMessage(AlertType.ERROR);
		} else {
			UserFeedBackForm form = new UserFeedBackForm(orderIDTextField.getText(), feedBackTypeChoiceBox.getValue(),
					feedBackThemeTextField.getText(), feedBackContentTextArea.getText());
			if (insert(form)) {
				controller.getMainApp().showSuccessDialog();				
			} else {
				util.setHanderMessage("δ��ѯ��������");
				util.setMessage("���������Ƿ�����");
				util.showMessage(AlertType.ERROR);
			}
		}
	}

	private boolean isInputVaild() {
		String errorHead = "";
		String errorMessage = "";

		if (orderIDTextField.getText().length() == 0 || orderIDTextField.getText() == null) {
			errorMessage += "δ���붩����\n";
		}

		if (feedBackTypeChoiceBox.getValue() == null) {
			errorMessage += "δѡ��������\n";
		}

		if (feedBackThemeTextField.getText().length() == 0 || feedBackThemeTextField.getText() == null) {
			errorMessage += "δ���뷴������\n";
		}

		if (feedBackContentTextArea.getText().length() == 0 || feedBackContentTextArea.getText() == null) {
			errorMessage += "δ���뷴������\n";
		}

		if (errorMessage.length() == 0) {
			return false;
		} else {
			errorHead += "��Ϣ���벻����";

			util.setHanderMessage(errorHead);
			util.setMessage(errorMessage);

			return true;
		}
	}

	private boolean insert(UserFeedBackForm form) {
		try {
			return select.createUserFeedbackFormByFeedbackInfo(controller.getMainApp().getUserLogin().getId(),
					Integer.valueOf(orderIDTextField.getText()).intValue(), feedBackTypeChoiceBox.getValue(),
					feedBackThemeTextField.getText(), feedBackContentTextArea.getText());
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
