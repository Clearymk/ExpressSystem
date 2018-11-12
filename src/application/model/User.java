package application.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User extends UserLogin{
	private StringProperty userID;
	private StringProperty username;
	private StringProperty userPassword;
	private StringProperty name;
	private StringProperty userPhoneNumber;
	private StringProperty userAddress;
	private ObjectProperty<UserType> userType;

	public User() {
		this(null, null, null, null, null);
	}

	public User(String username, String userPhoneNumber, String userRegion, String userAddress, UserType userType) {
		this.username = new SimpleStringProperty(username);
		this.userPhoneNumber = new SimpleStringProperty(userPhoneNumber);
		this.userAddress = new SimpleStringProperty(userAddress);
		this.userType = new SimpleObjectProperty<>(userType);

	}

	public String getUserID() {
		return userID.get();
	}

	public StringProperty userIDProperty() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID.set(userID);
	}

	public String getUsername() {
		return username.get();
	}

	public StringProperty usernameProperty() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username.set(username);
	}
	
	public String getUserPassword() {
		return userPassword.get();
	}

	public StringProperty userPasswordProperty() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword.set(userPassword);
	}
	

	public String getName() {
		return name.get();
	}

	public StringProperty nameProperty() {
		return name;
	}

	public void setName(String username) {
		this.name.set(username);
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber.get();
	}

	public StringProperty userPhoneNumberProperty() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber.set(userPhoneNumber);
	}

	public String getUserAddress() {
		return userAddress.get();
	}

	public StringProperty userAddressProperty() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress.set(userAddress);
	}

	public UserType getUserType() {
		return userType.get();
	}

	public ObjectProperty<UserType> userTypeProperty() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType.set(userType);
	}
}
