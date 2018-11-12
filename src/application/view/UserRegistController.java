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
		String[] requireInfoVaildPrompt = { "用户名不能为空", "密码不能为空" };
		form.installrequireValidation(requireInfoVaildate, requireInfoVaildPrompt);

		TextField[] phoneNumberInfoVaildate = { userPhoneNumberField };
		String[] phoneNumberVaildatePrompt = { "手机号不规范" };
		form.installRegularValidation(phoneNumberInfoVaildate, FormVaildateUtil.CHINAMOBILENO_REG,
				phoneNumberVaildatePrompt);

		TextField[] passwordVaildate = { userPasswordField };
		String[] passwordVaildatePrompt = { "密码不规范" };
		form.installRegularValidation(passwordVaildate, FormVaildateUtil.PASSWORD_REG, passwordVaildatePrompt);

		TextField[] emailInfoVaildate = { userEmailField };
		String[] emailVaildatePrompt = { "邮件号不规范" };
		form.installRegularValidation(emailInfoVaildate, FormVaildateUtil.EMAIL_REG, emailVaildatePrompt);

		form.confirmInfoValidation(userConfirmPasswordField, userPasswordField, "两次输入不一致");
	}

	@FXML
	private void successAlter() {
		if (form.isvalid()) {
			util.setHanderMessage("注册成功");
			util.setMessage("请您登录");
			util.showMessage(AlertType.INFORMATION);

			inserUser();

			controller.getMainApp().killRegistStage();
		} else {
			util.setHanderMessage("注册失败");
			util.setMessage("信息不完整");
			util.showMessage(AlertType.ERROR);
		}
	}

	private void inserUser() {

	}
}
