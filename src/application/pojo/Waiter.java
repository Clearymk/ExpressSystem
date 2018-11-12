/**
 * 
 */
package application.pojo;

import java.sql.Date;

/**
 *
 *
 * @author ly
 *
 *         2018�?6�?22日下�?6:44:13
 */
public class Waiter extends Employee {

	private float overtimePay;

	/**
	 * 
	 */
	public Waiter() {
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
	public Waiter(int man_StaffID, String username, String password, String staffName, Date staffBirthday,
			String staffGender, String staffPhoneNumber, float staffSalary) {
		super(man_StaffID, username, password, staffName, staffBirthday, staffGender, staffPhoneNumber, staffSalary);
	}

	public Waiter(int man_StaffID, String username, Date staffBirthday, String staffAddress, String staffGender,
			String staffPhoneNumber, float staffSalary) {
		super(man_StaffID, username, staffBirthday, staffAddress, staffGender, staffPhoneNumber, staffSalary);
	}

	/**
	 * @param loginUserID
	 */
	public Waiter(int loginUserID) {
		super(loginUserID);
	}

	/**
	 * @param overtimePay
	 */
	public Waiter(float overtimePay) {
		super();
		this.overtimePay = overtimePay;
	}

	/**
	 * @return the overtimePay
	 */
	public float getOvertimePay() {
		return overtimePay;
	}

	/**
	 * @param overtimePay
	 *            the overtimePay to set
	 */
	public void setOvertimePay(float overtimePay) {
		this.overtimePay = overtimePay;
	}

}
