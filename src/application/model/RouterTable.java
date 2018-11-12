package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RouterTable {
	private StringProperty expressID;
	private StringProperty conveyanceID;
	private StringProperty startAddress;
	private StringProperty targeAddress;
	private StringProperty dispatchCenterID;

	public void setExpressID(String expressID) {
		this.expressID.set(expressID);
		;
	}

	public String getExpressID() {
		return expressID.get();
	}

	public StringProperty expressIDProperty() {
		return expressID;
	}

	public void setConveyanceID(String conveyanceID) {
		this.expressID.set(conveyanceID);
		;
	}

	public String getConveyanceID() {
		return conveyanceID.get();
	}

	public StringProperty conveyanceIDProperty() {
		return conveyanceID;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress.set(startAddress);
		;
	}

	public String getStartAddress() {
		return startAddress.get();
	}

	public StringProperty startAddressProperty() {
		return startAddress;
	}

	public void setTargeAddress(String targeAddress) {
		this.targeAddress.set(targeAddress);
		;
	}

	public String getTargeAddress() {
		return targeAddress.get();
	}

	public StringProperty targeAddressProperty() {
		return targeAddress;
	}

	public void setDispatchCenterID(String dispatchCenterID) {
		this.dispatchCenterID.set(dispatchCenterID);
		;
	}

	public String getDispatchCenterID() {
		return dispatchCenterID.get();
	}

	public StringProperty dispatchCenterIDProperty() {
		return dispatchCenterID;
	}

	public RouterTable(String expressID, String conveyanceID, String startAdderss, String targeAddress,
			String dispatchCenterID) {
		this.expressID = new SimpleStringProperty(expressID);
		this.conveyanceID = new SimpleStringProperty(conveyanceID);
		this.startAddress = new SimpleStringProperty(startAdderss);
		this.targeAddress = new SimpleStringProperty(targeAddress);
		this.dispatchCenterID = new SimpleStringProperty(dispatchCenterID);
	}

	public RouterTable() {

	}
}
