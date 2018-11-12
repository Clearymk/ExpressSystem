package application.view;

import java.sql.Date;
import java.time.LocalDate;

import application.dao.Select;
import application.model.Employee;
import application.util.AlertUtil;
import application.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class EmployeeEditDialogController {
	@FXML
	private TextField employeeNameField;
	@FXML
	private TextField employeeBirthdayField;
	@FXML
	private TextField employeeSexField;
	@FXML
	private TextField employeePhoneNumberField;
	@FXML
	private TextField employeeAddressField;
	@FXML
	private TextField employeePositionField;
	@FXML
	private TextField employeeSalaryField;

	private AlertUtil util = AlertUtil.getAlertUtil();
	private Stage dialogStage;
	private Employee employee;
	private Select select = new Select();
	private boolean okClicked = false;

	public void setEmployee(Employee employee) {
		this.employee = employee;
		
		employeeNameField.setText(employee.getEmployeeName());
		employeeBirthdayField.setText(DateUtil.format(employee.getEmployeeBirthDay()));
		employeeBirthdayField.setPromptText("yyyy.MM.dd");
		employeeSexField.setText(employee.getEmployeeSex());
		employeePhoneNumberField.setText(employee.getEmployeePhoneNumber());
		employeeAddressField.setText(employee.getEmployeeAddress());
		employeePositionField.setText(employee.getEmployeePosition());
		employeeSalaryField.setText(employee.getEmployeeSalary().toString());
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			employee.setEmployeeName(employeeNameField.getText());
			employee.setEmployeeBirthDay(DateUtil.parse(employeeBirthdayField.getText()));
			employee.setEmployeeSex(employeeSexField.getText());
			employee.setEmployeePhoneNumber(employeePhoneNumberField.getText());
			employee.setEmployeeAddress(employeeAddressField.getText());
			employee.setEmployeePosition(employeePositionField.getText());
			employee.setEmployeeSalary(Double.parseDouble(employeeSalaryField.getText()));
			
			updateEmployee(Integer.valueOf(employee.getEmployeeID()), employee.getEmployeeName(), employee.getEmployeeSex(), employee.getEmployeePhoneNumber(), employee.getEmployeePosition(), Float.valueOf(String.valueOf(employee.getEmployeeSalary())), employee.getEmployeeBirthDay(), employee.getEmployeeAddress());
			
			okClicked = true;
			
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	public boolean isOkClicked() {
        return okClicked;
    }

	private boolean isInputValid() {
		String errorMessage = "";

		if (employeeBirthdayField.getText() == null || employeeBirthdayField.getText().length() == 0) {
			errorMessage += "δ����Ա������!\n";
		} else {
			if (!DateUtil.validDate(employeeBirthdayField.getText())) {
				errorMessage += "δ������ȷ������ �밴yyyy.MM.dd��ʽ����!\n";
			}
		}
		if (employeeSexField.getText() == null || employeeSexField.getText().length() == 0) {
			errorMessage += "δ����Ա���Ա�!\n";
		}

		if (employeePhoneNumberField.getText() == null || employeePhoneNumberField.getText().length() == 0) {
			errorMessage += "δ����Ա���绰����!\n";
		}
		if (employeeAddressField.getText() == null || employeeAddressField.getText().length() == 0) {
			errorMessage += "δ����Ա����ַ!\n";
		}
		if (employeeSalaryField.getText() == null || employeeSalaryField.getText().length() == 0) {
			errorMessage += "δ����Ա��н��!\n";
		} else {
			try {
				Double.parseDouble(employeeSalaryField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Ա��н����������!\n";
			}
		}

		if (employeePositionField.getText() == null || employeePositionField.getText().length() == 0) {
			errorMessage += "δ����Ա��ְλ!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			util.setHanderMessage("��������������������Ϣ");
			util.setMessage(errorMessage);
			util.showMessage(AlertType.ERROR);
			return false;
		}
	}
	
	private void updateEmployee(int staffID, String staffName, String staffGender, String staffPhoneNumber,
			String staffType, float staffSalary, LocalDate staffBirthday, String staffAddress) {
		try {
			select.updateEmployee(staffID, staffName, staffGender, staffPhoneNumber, staffType, staffSalary, Date.valueOf(staffBirthday), staffAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
