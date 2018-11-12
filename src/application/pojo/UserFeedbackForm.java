/**
 * 
 */
package application.pojo;

/**
 * Áî®Êà∑ÂèçÈ¶àÂç?
 *
 * @author ly
 *
 *         2018Âπ?6Êú?22Êó•‰∏ãÂç?1:55:06
 */
public class UserFeedbackForm {

	private int userFeedbackFormID;
	private int userID;
	private int orderID;
	private String userFeedbackType;
	private String userFeedbackTheme;
	private String userFeedbackContent;

	/**
	 * 
	 */
	public UserFeedbackForm() {
		super();
	}

	/**
	 * @param userFeedbackFormID
	 * @param userID
	 * @param orderID
	 * @param userFeedbackType
	 * @param userFeedbackTheme
	 * @param userFeedbackContent
	 */
	public UserFeedbackForm(int userFeedbackFormID, int userID, int orderID, String userFeedbackType,
			String userFeedbackTheme, String userFeedbackContent) {
		super();
		this.userFeedbackFormID = userFeedbackFormID;
		this.userID = userID;
		this.orderID = orderID;
		this.userFeedbackType = userFeedbackType;
		this.userFeedbackTheme = userFeedbackTheme;
		this.userFeedbackContent = userFeedbackContent;
	}

	/**
	 * @return the userFeedbackFormID
	 */
	public int getUserFeedbackFormID() {
		return userFeedbackFormID;
	}

	/**
	 * @param userFeedbackFormID
	 *            the userFeedbackFormID to set
	 */
	public void setUserFeedbackFormID(int userFeedbackFormID) {
		this.userFeedbackFormID = userFeedbackFormID;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the orderID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * @param orderID
	 *            the orderID to set
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * @return the userFeedbackType
	 */
	public String getUserFeedbackType() {
		return userFeedbackType;
	}

	/**
	 * @param userFeedbackType
	 *            the userFeedbackType to set
	 */
	public void setUserFeedbackType(String userFeedbackType) {
		this.userFeedbackType = userFeedbackType;
	}

	/**
	 * @return the userFeedbackTheme
	 */
	public String getUserFeedbackTheme() {
		return userFeedbackTheme;
	}

	/**
	 * @param userFeedbackTheme
	 *            the userFeedbackTheme to set
	 */
	public void setUserFeedbackTheme(String userFeedbackTheme) {
		this.userFeedbackTheme = userFeedbackTheme;
	}

	/**
	 * @return the userFeedbackContent
	 */
	public String getUserFeedbackContent() {
		return userFeedbackContent;
	}

	/**
	 * @param userFeedbackContent
	 *            the userFeedbackContent to set
	 */
	public void setUserFeedbackContent(String userFeedbackContent) {
		this.userFeedbackContent = userFeedbackContent;
	}

}
