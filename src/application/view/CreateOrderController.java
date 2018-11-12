package application.view;

import java.time.LocalDate;

import application.dao.Select;
import application.util.AlertUtil;
import application.util.FormVaildateUtil;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CreateOrderController {
	@FXML
	private TextField senderUsernameTextField;
	@FXML
	private TextField senderUserPhoneNumberTextField;
	@FXML
	private TextField senderProvinceTextField;
	@FXML
	private TextField senderCityTextField;
	@FXML
	private TextField senderAreaTextField;
	@FXML
	private TextField senderAddressTextField;
	@FXML
	private TextField recipientUsernameTextField;
	@FXML
	private TextField recipientUserPhoneNumberTextField;
	@FXML
	private TextField recipientProvinceTextField;
	@FXML
	private TextField recipientCityTextField;
	@FXML
	private TextField recipientAreaTextField;
	@FXML
	private TextField recipientAddressTextField;

	private FeatureController controller = FeatureController.getController();
	private AlertUtil util = AlertUtil.getAlertUtil();
	private FormVaildateUtil<TextField> form;
	private Select select = new Select();
	private int orderID;
	
	@FXML
	private void initialize() {
		final BooleanProperty firstTime = new SimpleBooleanProperty(true);
		recipientAddressTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue && firstTime.get()) {
				controller.getMainApp().getPrimaryStage().requestFocus();
				firstTime.setValue(false);
			}
		});

		vaildateCheck();
	}

	private void vaildateCheck() {
		form = new FormVaildateUtil<>();

		TextField[] requireInfoVaildate = { senderUsernameTextField, senderProvinceTextField, senderCityTextField,
				senderAreaTextField, senderAddressTextField, recipientUsernameTextField, recipientProvinceTextField,
				recipientCityTextField, recipientAreaTextField, recipientAddressTextField };
		String[] requireInfoVaildPrompt = { "收件人用户名不能为空", "省份不能为空", "市不能为空", "区不能为空", "收件人详细地址不能为空", "寄件人用户名不能为空",
				"省份不能为空", "市不能为空", "区不能为空", "寄件人详细地址不能为空" };

		form.installrequireValidation(requireInfoVaildate, requireInfoVaildPrompt);

		TextField[] phoneNumberInfoVaildate = { senderUserPhoneNumberTextField, recipientUserPhoneNumberTextField };
		String[] phoneNumberVaildatePrompt = { "寄件人手机号不规范", "收件人手机号不规范" };

		form.installRegularValidation(phoneNumberInfoVaildate, FormVaildateUtil.CHINAMOBILENO_REG,
				phoneNumberVaildatePrompt);
	}

	@FXML
	private void successAlter() {
		if (form.isvalid()) {
			insertOrder();
			util.setHanderMessage("订单提交成功");
			util.setMessage("您的订单号为" + orderID);
			util.showMessage(AlertType.INFORMATION);

		} else {
			util.setHanderMessage("订单提交失败");
			util.setMessage("信息不完整");
			util.showMessage(AlertType.ERROR);
		}
	}

	private void insertOrder() {
		try {
			 orderID = select.createOrderBySenderReceiverInfo(senderUsernameTextField.getText(), recipientUsernameTextField.getText(),
					senderProvinceTextField.getText() + "省" + senderCityTextField.getText() + "市" + senderAreaTextField.getText()
							+ "区" + senderAddressTextField.getText(),
					recipientProvinceTextField.getText() + "省" + recipientCityTextField.getText() + "市" + recipientAreaTextField.getText()
							+ "区" + recipientAddressTextField.getText(), LocalDate.now());
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
