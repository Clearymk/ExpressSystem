package application.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewFeedbackForm {
	private final StringProperty surveyFeedbackFormID;
	private final StringProperty orderID;
	private final StringProperty location;
	private final StringProperty orderState;
	private final ObjectProperty<LocalDate> surveyTime;

	public ViewFeedbackForm(String orderID) {
		this.surveyFeedbackFormID = new SimpleStringProperty("null");
		this.orderID = new SimpleStringProperty(orderID);
		this.location = new SimpleStringProperty(null);
		this.orderState = new SimpleStringProperty(null);
		this.surveyTime = new SimpleObjectProperty<LocalDate>(null);
	}
	
	public ViewFeedbackForm(String orderID, String location, String orderState, LocalDate surveyTime) {
		this.surveyFeedbackFormID = new SimpleStringProperty("null");
		this.orderID = new SimpleStringProperty(orderID);
		this.location = new SimpleStringProperty(location);
		this.orderState = new SimpleStringProperty(orderState);
		this.surveyTime = new SimpleObjectProperty<LocalDate>(surveyTime);
	}
	
	public String getSurveyFeedbackFormID() {
		return surveyFeedbackFormID.get();
	}
	
	public void setSurveyFeedbackFormID(String surveyFeedbackFormID) {
		this.surveyFeedbackFormID.set(surveyFeedbackFormID);;
	}
	
	public StringProperty surveyFeedbackFormIDProperty() {
		return surveyFeedbackFormID;
	}
	
	public String getOrderID() {
		return orderID.get();
	}
	
	public void setOrderID(String orderID) {
		this.orderID.set(orderID);
	}
	
	public StringProperty orderIDProperty() {
		return orderID;
	}

	public String getLocation() {
		return location.get();
	}
	
	public void setLocation(String location) {
		this.location.set(location);
	}
	
	public StringProperty locationProperty() {
		return location;
	}


	public String getOrderState() {
		return orderState.get();
	}
	
	public void setOrderState(String orderState) {
		this.orderState.set(orderState);
	}
	
	public StringProperty orderStateProperty() {
		return orderState;
	}
	
	public LocalDate getSurveyTime() {
		return surveyTime.get();
	}
	
	public void setSurveyTime(LocalDate surveyTime) {
		this.surveyTime.set(surveyTime);
	}
	
	public ObjectProperty<LocalDate> surveyTimeProperty() {
		return surveyTime;
	}
}
