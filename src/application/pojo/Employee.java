/**
 * 
 */
package application.pojo;

import java.sql.Date;

/**
 * 服务�?
 *
 * @author ly
 *
 *         2018�?6�?22日下�?6:20:28
 */
public class Employee extends LoginUser {

	private int man_StaffID;
	private String username;
	private String password;
	private String staffName;
	private Date staffBirthday;
	private String staffAddress;
	private String staffGender;
	private String staffPhoneNumber;
	private float staffSalary;

	/**
	 * 
	 */
	public Employee() {
		super();
	}

	/**
	 * @param loginUserID
	 */
	public Employee(int loginUserID) {
		super(loginUserID);
	}

	/**
	 * @param man_StaffID
	 * @param username
	 * @param password
	 * @param staffName
	 * @param staffBirthday
	 * @param staffGender
	 * @param staffPhoneNumber
	 * @param staffSalary
	 */
	public Employee(int man_StaffID, String username, String password, String staffName, Date staffBirthday,
			String staffGender, String staffPhoneNumber, float staffSalary) {
		this.man_StaffID = man_StaffID;
		this.username = username;
		this.password = password;
		this.staffName = staffName;
		this.staffBirthday = staffBirthday;
		this.staffGender = staffGender;
		this.staffPhoneNumber = staffPhoneNumber;
		this.staffSalary = staffSalary;
	}

	/**
	 * @param man_StaffID
	 * @param staffName
	 * @param staffBirthday
	 * @param staffGender
	 * @param staffPhoneNumber
	 * @param staffSalary
	 */
	public Employee(int man_StaffID, String staffName, Date staffBirthday, String staffAddress, String staffGender, String staffPhoneNumber,
			float staffSalary) {
		super();
		this.man_StaffID = man_StaffID;
		this.staffName = staffName;
		this.staffBirthday = staffBirthday;
		this.staffAddress = staffAddress;
		this.staffGender = staffGender;
		this.staffPhoneNumber = staffPhoneNumber;
		this.staffSalary = staffSalary;
	}

	/**
	 * @param username
	 * @param password
	 * @param staffName
	 * @param staffBirthday
	 * @param staffGender
	 * @param staffPhoneNumber
	 * @param staffSalary
	 */
	public Employee(String username, String password, String staffName, Date staffBirthday, String staffGender,
			String staffPhoneNumber, float staffSalary) {
		super();
		this.username = username;
		this.password = password;
		this.staffName = staffName;
		this.staffBirthday = staffBirthday;
		this.staffGender = staffGender;
		this.staffPhoneNumber = staffPhoneNumber;
		this.staffSalary = staffSalary;
	}

	/**
	 * @return the man_StaffID
	 */
	public int getMan_StaffID() {
		return man_StaffID;
	}

	/**
	 * @param man_StaffID
	 *            the man_StaffID to set
	 */
	public void setMan_StaffID(int man_StaffID) {
		this.man_StaffID = man_StaffID;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "Employee [man_StaffID=" + man_StaffID + ", username=" + username + ", password=" + password
				+ ", staffName=" + staffName + ", staffBirthday=" + staffBirthday + ", staffAddress=" + staffAddress
				+ ", staffGender=" + staffGender + ", staffPhoneNumber=" + staffPhoneNumber + ", staffSalary="
				+ staffSalary + "]";
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the staffName
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * @param staffName
	 *            the staffName to set
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * @return the staffBirthday
	 */
	public Date getStaffBirthday() {
		return staffBirthday;
	}

	/**
	 * @param staffBirthday
	 *            the staffBirthday to set
	 */
	public void setStaffBirthday(Date staffBirthday) {
		this.staffBirthday = staffBirthday;
	}

	/**
	 * @return the staffGender
	 */
	public String getStaffGender() {
		return staffGender;
	}

	/**
	 * @param staffGender
	 *            the staffGender to set
	 */
	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	/**
	 * @return the staffPhoneNumber
	 */
	public String getStaffPhoneNumber() {
		return staffPhoneNumber;
	}

	/**
	 * @param staffPhoneNumber
	 *            the staffPhoneNumber to set
	 */
	public void setStaffPhoneNumber(String staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}

	/**
	 * @return the staffSalary
	 */
	public float getStaffSalary() {
		return staffSalary;
	}

	/**
	 * @param staffSalary
	 *            the staffSalary to set
	 */
	public void setStaffSalary(float staffSalary) {
		this.staffSalary = staffSalary;
	}

	public String getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

}
