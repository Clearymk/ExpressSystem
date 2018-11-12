package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserFeedBackForm {
	private StringProperty orderID;
	private StringProperty userFeedBackType;
	private StringProperty userFeedBackTheme;
	private StringProperty userFeedBackContent;

	public UserFeedBackForm(String orderID, String userFeedBackType, String userFeedBackTheme,
			String userFeedBackContent) {
		this.orderID = new SimpleStringProperty(orderID);
		this.userFeedBackType = new SimpleStringProperty(userFeedBackType);
		this.userFeedBackTheme = new SimpleStringProperty(userFeedBackTheme);
		this.userFeedBackContent = new SimpleStringProperty(userFeedBackContent);
	}
	
	public UserFeedBackForm() {
		
	}

	public void setOrderID(String orderID) {
		this.orderID = new SimpleStringProperty(orderID);
	}

	public String getOrderID() {
		return orderID.get();
	}

	public StringProperty orderIDProperty() {
		return orderID;
	}

	public void setUserFeedBackType(String userFeedBackType) {
		this.userFeedBackType = new SimpleStringProperty(userFeedBackType);
	}

	public String getUserFeedBackType() {
		return userFeedBackType.get();
	}

	public StringProperty userFeedBackTypeProperty() {
		return orderID;
	}

	public void setUserFeedBackTheme(String userFeedBackTheme) {
		this.userFeedBackTheme = new SimpleStringProperty(userFeedBackTheme);
	}

	public String getUserFeedBackTheme() {
		return userFeedBackTheme.get();
	}

	public StringProperty userFeedBackThemeProperty() {
		return userFeedBackTheme;
	}

	public void setUserFeedBackContent(String userFeedBackContent) {
		this.userFeedBackContent = new SimpleStringProperty(userFeedBackContent);
	}

	public String getUserFeedBackContent() {
		return userFeedBackContent.get();
	}

	public StringProperty userFeedBackContentProperty() {
		return userFeedBackContent;
	}

}
