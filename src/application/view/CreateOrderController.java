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
		String[] requireInfoVaildPrompt = { "�ռ����û�������Ϊ��", "ʡ�ݲ���Ϊ��", "�в���Ϊ��", "������Ϊ��", "�ռ�����ϸ��ַ����Ϊ��", "�ļ����û�������Ϊ��",
				"ʡ�ݲ���Ϊ��", "�в���Ϊ��", "������Ϊ��", "�ļ�����ϸ��ַ����Ϊ��" };

		form.installrequireValidation(requireInfoVaildate, requireInfoVaildPrompt);

		TextField[] phoneNumberInfoVaildate = { senderUserPhoneNumberTextField, recipientUserPhoneNumberTextField };
		String[] phoneNumberVaildatePrompt = { "�ļ����ֻ��Ų��淶", "�ռ����ֻ��Ų��淶" };

		form.installRegularValidation(phoneNumberInfoVaildate, FormVaildateUtil.CHINAMOBILENO_REG,
				phoneNumberVaildatePrompt);
	}

	@FXML
	private void successAlter() {
		if (form.isvalid()) {
			insertOrder();
			util.setHanderMessage("�����ύ�ɹ�");
			util.setMessage("���Ķ�����Ϊ" + orderID);
			util.showMessage(AlertType.INFORMATION);

		} else {
			util.setHanderMessage("�����ύʧ��");
			util.setMessage("��Ϣ������");
			util.showMessage(AlertType.ERROR);
		}
	}

	private void insertOrder() {
		try {
			 orderID = select.createOrderBySenderReceiverInfo(senderUsernameTextField.getText(), recipientUsernameTextField.getText(),
					senderProvinceTextField.getText() + "ʡ" + senderCityTextField.getText() + "��" + senderAreaTextField.getText()
							+ "��" + senderAddressTextField.getText(),
					recipientProvinceTextField.getText() + "ʡ" + recipientCityTextField.getText() + "��" + recipientAreaTextField.getText()
							+ "��" + recipientAddressTextField.getText(), LocalDate.now());
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
