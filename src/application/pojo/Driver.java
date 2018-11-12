/**
 * 
 */
package application.pojo;

import java.sql.Date;

/**
 * 司机
 *
 * @author ly
 *
 *         2018�?6�?22日下�?6:36:39
 */
public class Driver extends Employee {

	private int dispatchCenterID;
	private String state;

	/**
	 * 
	 */
	public Driver() {
		super();
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
	public Driver(int man_StaffID, String username, String password, String staffName, Date staffBirthday,
			String staffGender, String staffPhoneNumber, float staffSalary) {
		super(man_StaffID, username, password, staffName, staffBirthday, staffGender, staffPhoneNumber, staffSalary);
	}

	/**
	 * @param loginUserID
	 */
	public Driver(int loginUserID) {
		super(loginUserID);
	}

	/**
	 * @param dispatchCenterID
	 * @param state
	 */
	public Driver(int dispatchCenterID, String state) {
		super();
		this.dispatchCenterID = dispatchCenterID;
		this.state = state;
	}
	
	public Driver(int man_StaffID, String username, Date staffBirthday, String staffAddress , String staffGender, String staffPhoneNumber, float staffSalary) {
		super(man_StaffID, username, staffBirthday, staffAddress, staffGender, staffPhoneNumber, staffSalary);
	}

	/**
	 * @return the dispatchCenterID
	 */
	public int getDispatchCenterID() {
		return dispatchCenterID;
	}

	/**
	 * @param dispatchCenterID
	 *            the dispatchCenterID to set
	 */
	public void setDispatchCenterID(int dispatchCenterID) {
		this.dispatchCenterID = dispatchCenterID;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
