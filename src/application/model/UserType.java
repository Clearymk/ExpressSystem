package application.model;

public enum UserType {
	USER_TYPE_SENDER("sender"), USER_TYPE_RECIPIENT("recipient");

	private String type;

	private UserType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
