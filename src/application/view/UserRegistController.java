package application.view;

import application.util.AlertUtil;
import application.util.FormVaildateUtil;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UserRegistController {
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField userPasswordField;
	@FXML
	private PasswordField userConfirmPasswordField;
	@FXML
	private TextField userPhoneNumberField;
	@FXML
	private TextField userEmailField;

	private FeatureController controller = FeatureController.getController();
	private AlertUtil util = AlertUtil.getAlertUtil();
	private FormVaildateUtil<TextField> form;

	@FXML
	private void initialize() {
		final BooleanProperty firstTime = new SimpleBooleanProperty(true);
		userEmailField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue && firstTime.get()) {
				controller.getMainApp().getPrimaryStage().requestFocus();
				firstTime.setValue(false);
			}
		});

		vaildateCheck();
	}

	private void vaildateCheck() {
		form = new FormVaildateUtil<>();

		TextField[] requireInfoVaildate = { usernameField, userPasswordField };
		String[] requireInfoVaildPrompt = { "�û�������Ϊ��", "���벻��Ϊ��" };
		form.installrequireValidation(requireInfoVaildate, requireInfoVaildPrompt);

		TextField[] phoneNumberInfoVaildate = { userPhoneNumberField };
		String[] phoneNumberVaildatePrompt = { "�ֻ��Ų��淶" };
		form.installRegularValidation(phoneNumberInfoVaildate, FormVaildateUtil.CHINAMOBILENO_REG,
				phoneNumberVaildatePrompt);

		TextField[] passwordVaildate = { userPasswordField };
		String[] passwordVaildatePrompt = { "���벻�淶" };
		form.installRegularValidation(passwordVaildate, FormVaildateUtil.PASSWORD_REG, passwordVaildatePrompt);

		TextField[] emailInfoVaildate = { userEmailField };
		String[] emailVaildatePrompt = { "�ʼ��Ų��淶" };
		form.installRegularValidation(emailInfoVaildate, FormVaildateUtil.EMAIL_REG, emailVaildatePrompt);

		form.confirmInfoValidation(userConfirmPasswordField, userPasswordField, "�������벻һ��");
	}

	@FXML
	private void successAlter() {
		if (form.isvalid()) {
			util.setHanderMessage("ע��ɹ�");
			util.setMessage("������¼");
			util.showMessage(AlertType.INFORMATION);

			inserUser();

			controller.getMainApp().killRegistStage();
		} else {
			util.setHanderMessage("ע��ʧ��");
			util.setMessage("��Ϣ������");
			util.showMessage(AlertType.ERROR);
		}
	}

	private void inserUser() {

	}
}
