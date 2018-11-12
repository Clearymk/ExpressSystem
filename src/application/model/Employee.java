package application.model;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee extends UserLogin{
	private StringProperty employeeID;
	private StringProperty employeeName;
	private StringProperty employeePhoneNumber;
	private StringProperty employeeSex;
	private ObjectProperty<LocalDate> employeeBirthDay;
	private StringProperty employeeAddress;
	private StringProperty employeePosition;
	private DoubleProperty employeeSalary;

	public String getEmployeeID() {
		return employeeID.get();
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID.set(employeeID);
	}

	public StringProperty employeeIDProperty() {
		return employeeID;
	}

	public String getEmployeeName() {
		return employeeName.get();
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName.set(employeeName);
	}

	public StringProperty employeeNameProperty() {
		return employeeName;
	}

	public String getEmployeePhoneNumber() {
		return employeePhoneNumber.get();
	}

	public void setEmployeePhoneNumber(String employeePhoneNumber) {
		this.employeePhoneNumber.set(employeePhoneNumber);
	}

	public StringProperty employeePhoneNumberProperty() {
		return employeePhoneNumber;
	}

	public String getEmployeeSex() {
		return employeeSex.get();
	}

	public void setEmployeeSex(String employeeSex) {
		this.employeeSex.set(employeeSex);
	}

	public StringProperty employeeSexProperty() {
		return employeeSex;
	}

	public LocalDate getEmployeeBirthDay() {
		return employeeBirthDay.get();
	}

	public void setEmployeeBirthDay(LocalDate employeeBirthDay) {
		this.employeeBirthDay.set(employeeBirthDay);
	}

	public ObjectProperty<LocalDate> employeeBirthDayProperty() {
		return employeeBirthDay;
	}

	public String getEmployeeAddress() {
		return employeeAddress.get();
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress.set(employeeAddress);
	}

	public StringProperty employeeAddressProperty() {
		return employeeAddress;
	}

	public String getEmployeePosition() {
		return employeePosition.get();
	}

	public void setEmployeePosition(String employeePosition) {
		this.employeePosition.set(employeePosition);
	}

	public StringProperty employeePositionProperty() {
		return employeePosition;
	}

	public Double getEmployeeSalary() {
		return employeeSalary.get();
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary.set(employeeSalary);
	}

	public DoubleProperty employeeSalaryProperty() {
		return this.employeeSalary;
	}
	
	public Employee(String employeeID, LocalDate employeeBirthday, String employeeSex, String employeePhoneNumber, String employeePosition, Double employeeSalary) {
		this.employeeID = new SimpleStringProperty(employeeID);
		this.employeeBirthDay = new SimpleObjectProperty<LocalDate>(employeeBirthday);
		this.employeeSex = new SimpleStringProperty(employeeSex);
		this.employeePhoneNumber = new SimpleStringProperty(employeePhoneNumber);
		this.employeePosition = new SimpleStringProperty(employeePosition);
		this.employeeSalary = new SimpleDoubleProperty(employeeSalary);
	}

	public Employee(String employeeID, String employeeName, String employeePhoneNumber, String employeeSex,
			LocalDate employeeBirthDay, String employeeAddress, String employeePosition, Double employeeSalary) {
		this.employeeID = new SimpleStringProperty(employeeID);
		this.employeeName = new SimpleStringProperty(employeeName);
		this.employeePhoneNumber = new SimpleStringProperty(employeePhoneNumber);
		this.employeeSex = new SimpleStringProperty(employeeSex);
		this.employeeBirthDay = new SimpleObjectProperty<LocalDate>(employeeBirthDay);
		this.employeeAddress = new SimpleStringProperty(employeeAddress);
		this.employeePosition = new SimpleStringProperty(employeePosition);
		this.employeeSalary = new SimpleDoubleProperty(employeeSalary);
	}

	public Employee() {
		this("", "", "", "", LocalDate.of(2016, 10, 5), "", "", 0.0);
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeePhoneNumber="
				+ employeePhoneNumber + ", employeeSex=" + employeeSex + ", employeeBirthDay=" + employeeBirthDay
				+ ", employeeAddress=" + employeeAddress + ", employeePosition=" + employeePosition
				+ ", employeeSalary=" + employeeSalary + "]";
	}
}
