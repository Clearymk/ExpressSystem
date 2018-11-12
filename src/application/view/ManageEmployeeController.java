package application.view;

import java.util.List;

import application.dao.Select;
import application.model.Employee;
import application.util.AlertUtil;
import application.util.DateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class ManageEmployeeController {
	@FXML
	private TableView<Employee> employeeTableView;
	@FXML
	private TableColumn<Employee, String> employeeNameTableColumn;
	@FXML
	private Label employeeIDLabel;
	@FXML
	private Label employeeBirthdayLabel;
	@FXML
	private Label employeeSexLabel;
	@FXML
	private Label employeePhoneNameLabel;
	@FXML
	private Label employeeAddressLabel;
	@FXML
	private Label employeePositionLabel;
	@FXML
	private Label employeeSalaryLabel;

	private ObservableList<Employee> employees = FXCollections.observableArrayList();
	private AlertUtil util = AlertUtil.getAlertUtil();
	private FeatureController controller = FeatureController.getController();
	private Select select = new Select();

	@FXML
	private void initialize() {
		queryEmployee(controller.getMainApp().getUserLogin().getId());

		employeeTableView.setItems(employees);

		employeeNameTableColumn.setCellValueFactory(cellData -> cellData.getValue().employeeNameProperty());

		showEmployeeDetails(null);

		employeeTableView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showEmployeeDetails(newValue));
	}

	@FXML
	private void handlerDeleteEmployee() {
		int selectedIndex = employeeTableView.getSelectionModel().getSelectedIndex();
		
		if (selectedIndex >= 0) {
			Employee e = employeeTableView.getItems().get(selectedIndex);
			deleteEmployee(Integer.valueOf(e.getEmployeeID()), e.getEmployeePosition());
			employeeTableView.getItems().remove(selectedIndex);
		} else {
			util.setHanderMessage("未选择员工");
			util.setMessage("请从表中选择一名员工");
			util.showMessage(AlertType.ERROR);
		}

	}

	private void showEmployeeDetails(Employee employee) {
		if (employee != null) {
			employeeIDLabel.setText(employee.getEmployeeID());
			employeeBirthdayLabel.setText(DateUtil.format(employee.getEmployeeBirthDay()));
			employeeSexLabel.setText(employee.getEmployeeSex());
			employeePhoneNameLabel.setText(employee.getEmployeePhoneNumber());
			employeeAddressLabel.setText(employee.getEmployeeAddress());
			employeePositionLabel.setText(employee.getEmployeePosition());
			employeeSalaryLabel.setText(String.valueOf(employee.getEmployeeSalary()));

		} else {
			employeeIDLabel.setText("");
			employeeBirthdayLabel.setText("");
			employeeSexLabel.setText("");
			employeePhoneNameLabel.setText("");
			employeeAddressLabel.setText("");
			employeePositionLabel.setText("");
			employeeSalaryLabel.setText("");
		}
	}

	@FXML
	private void handleNewPerson() {
		Employee tempPerson = new Employee();
		boolean okClicked = controller.getMainApp().showPersonEditDialog(tempPerson);
		if (okClicked) {
			employees.add(tempPerson);
			employeeTableView.setItems(employees);
		}
	}

	@FXML
	private void handleEditPerson() {
		Employee selectedEmployee = employeeTableView.getSelectionModel().getSelectedItem();
		if (selectedEmployee != null) {
			boolean okClicked = controller.getMainApp().showPersonEditDialog(selectedEmployee);
			if (okClicked) {
				showEmployeeDetails(selectedEmployee);
			}

		} else {
			util.setHanderMessage("未选择员工");
			util.setMessage("请从表中选择一名员工");
			util.showMessage(AlertType.ERROR);
		}
	}

	private void queryEmployee(int managerID) {
		try {
			List<application.pojo.Employee> list = select.selectEmployeeManagedByManager(managerID);
			for (application.pojo.Employee employee : list) {
				Employee e = new Employee(String.valueOf(employee.getMan_StaffID()), employee.getStaffName(),
						employee.getStaffPhoneNumber(), employee.getStaffGender(),
						employee.getStaffBirthday().toLocalDate(),
						employee.getStaffAddress(), employee.getClass().getSimpleName(),
						Double.valueOf(String.valueOf(employee.getStaffSalary())));
				employees.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteEmployee(int employeeID, String staffType) {
		try {
			select.deleteEmployee(employeeID, staffType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
