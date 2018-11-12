package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrderInfo {
	private StringProperty orderId;
	private StringProperty senderName;
	private StringProperty senderPhoneNumber;
	private StringProperty recipientName;
	private StringProperty recipientPhoneNumber;
	private StringProperty senderAddress;
	private StringProperty recipientAddress;

	public OrderInfo() {

	}

	public OrderInfo(String orderId, String senderName, String senderPhoneNumber, String recipientName,
			String recipientPhoneNumber, String senderAddress, String recipientAddress) {
		this.orderId = new SimpleStringProperty(orderId);
		this.senderName = new SimpleStringProperty(senderName);
		this.senderPhoneNumber = new SimpleStringProperty(senderPhoneNumber);
		this.recipientName = new SimpleStringProperty(recipientName);
		this.recipientPhoneNumber = new SimpleStringProperty(recipientPhoneNumber);
		this.senderAddress = new SimpleStringProperty(senderAddress);
		this.recipientAddress = new SimpleStringProperty(recipientAddress);
	}

	public String getOrderId() {
		return orderId.get();
	}

	public void setOrderId(String orderId) {
		this.orderId.set(orderId);
	}

	public StringProperty orderIdProperty() {
		return orderId;
	}

	public String getSenderName() {
		return senderName.get();
	}

	public void setSenderName(String senderName) {
		this.senderName.set(senderName);
	}

	public StringProperty senderNameProperty() {
		return senderName;
	}

	public String getSenderPhoneNumberProperty() {
		return senderPhoneNumber.get();
	}

	public void setSenderPhoneNumber(String senderPhoneNumber) {
		this.senderPhoneNumber.set(senderPhoneNumber);
	}

	public StringProperty senderPhoneNumberProperty() {
		return senderPhoneNumber;
	}

	public String getRecipientName() {
		return recipientName.get();
	}

	public void setRecipientName(String recipientName) {
		this.recipientName.set(recipientName);
		;
	}

	public StringProperty recipientNameProperty() {
		return recipientName;
	}

	public String getRecipientPhoneNumber() {
		return recipientPhoneNumber.get();
	}

	public void setRecipientPhoneNumber(String recipientPhoneNumber) {
		this.recipientPhoneNumber.set(recipientPhoneNumber);
	}

	public StringProperty recipientPhoneNumberProperty() {
		return recipientPhoneNumber;
	}

	public String getSenderAddressProperty() {
		return senderAddress.get();
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress.set(senderAddress);
	}

	public StringProperty senderAddressProperty() {
		return senderAddress;
	}

	public String getRecipientAddress() {
		return recipientAddress.get();
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress.set(recipientAddress);
	}

	public StringProperty recipientAddressProperty() {
		return recipientAddress;
	}

}
