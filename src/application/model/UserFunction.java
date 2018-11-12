package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserFunction {
	private final StringProperty functionName;
	private final StringProperty functionCode;
	
	public UserFunction() {
		this(null, null);
	}

	public UserFunction(String functionName, String functionCode) {
		this.functionName = new SimpleStringProperty(functionName);
		this.functionCode = new SimpleStringProperty(functionCode);
	}

	public StringProperty getFunctionNameProperty() {
		return functionName;
	}
	
	public String getFuntionNameString() {
		return functionName.get();
	}
	
	public String getFunctionCodeString() {
		return functionCode.get();
	}
	
	public StringProperty getFunctionName() {
		return functionName;
	}

	public StringProperty getFunctionCode() {
		return functionCode;
	}
	
}
