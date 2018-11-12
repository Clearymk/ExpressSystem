/**
 * 
 */
package application.pojo;

/**
 * User
 *
 * @author ly
 *
 *         2018Âπ?6Êú?20Êó•‰∏ãÂç?4:39:51
 */
public class User extends LoginUser {

	private String username;
	private String password;
	private String name;
	private String userPhoneNummber;
	private String userEmailAddress;
	private String userType;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param loginUserID
	 */
	public User(int loginUserID) {
		super(loginUserID);
	}

	/**
	 * @param username
	 * @param password
	 * @param name
	 * @param userPhoneNummber
	 * @param userEmailAddress
	 * @param userType
	 */
	public User(String username, String password, String name, String userPhoneNummber, String userEmailAddress,
			String userType) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.userPhoneNummber = userPhoneNummber;
		this.userEmailAddress = userEmailAddress;
		this.userType = userType;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the userPhoneNummber
	 */
	public String getUserPhoneNummber() {
		return userPhoneNummber;
	}

	/**
	 * @param userPhoneNummber
	 *            the userPhoneNummber to set
	 */
	public void setUserPhoneNummber(String userPhoneNummber) {
		this.userPhoneNummber = userPhoneNummber;
	}

	/**
	 * @return the userEmailAddress
	 */
	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	/**
	 * @param userEmailAddress
	 *            the userEmailAddress to set
	 */
	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
