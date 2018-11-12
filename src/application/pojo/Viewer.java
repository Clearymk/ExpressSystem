/**
 * 
 */
package application.pojo;

import java.sql.Date;

/**
 * �?视员
 *
 * @author ly
 *
 *         2018�?6�?22日下�?6:56:29
 */
public class Viewer extends Employee {

	private float passRate;

	/**
	 * 
	 */
	public Viewer() {
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
	public Viewer(int man_StaffID, String username, String password, String staffName, Date staffBirthday,
			String staffGender, String staffPhoneNumber, float staffSalary) {
		super(man_StaffID, username, password, staffName, staffBirthday, staffGender, staffPhoneNumber, staffSalary);
	}

	public Viewer(int man_StaffID, String username, Date staffBirthday, String staffAddress, String staffGender,
			String staffPhoneNumber, float staffSalary) {
		super(man_StaffID, username, staffBirthday, staffAddress, staffGender, staffPhoneNumber, staffSalary);
	}

	/**
	 * @param loginUserID
	 */
	public Viewer(int loginUserID) {
		super(loginUserID);
	}

	/**
	 * @param passRate
	 */
	public Viewer(float passRate) {
		super();
		this.passRate = passRate;
	}

	/**
	 * @return the passRate
	 */
	public float getPassRate() {
		return passRate;
	}

	/**
	 * @param passRate
	 *            the passRate to set
	 */
	public void setPassRate(float passRate) {
		this.passRate = passRate;
	}

}
