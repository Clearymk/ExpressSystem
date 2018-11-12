/**
 * 
 */
package application.pojo;

import java.sql.Date;

/**
 * ËÆ¢Âçï
 *
 * @author ly
 *
 *         2018Âπ?6Êú?21Êó•‰∏ãÂç?8:48:49
 */
public class Order {

	private int orderID;
	private int senderID;
	private int receiverID;
	private String sendAddress;
	private String receiveAddress;
	private Date acceptDate;

	/**
	 * 
	 */
	public Order() {
		super();
	}

	/**
	 * @param orderID
	 * @param senderID
	 * @param receiverID
	 * @param sendAddress
	 * @param receiveAddress
	 */
	public Order(int orderID, int senderID, int receiverID, String sendAddress, String receiveAddress) {
		super();
		this.orderID = orderID;
		this.senderID = senderID;
		this.receiverID = receiverID;
		this.sendAddress = sendAddress;
		this.receiveAddress = receiveAddress;
	}

	/**
	 * @param orderID
	 * @param senderID
	 * @param receiverID
	 * @param sendAddress
	 * @param receiveAddress
	 * @param acceptDate
	 */
	public Order(int orderID, int senderID, int receiverID, String sendAddress, String receiveAddress,
			Date acceptDate) {
		super();
		this.orderID = orderID;
		this.senderID = senderID;
		this.receiverID = receiverID;
		this.sendAddress = sendAddress;
		this.receiveAddress = receiveAddress;
		this.acceptDate = acceptDate;
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
	 * @return the senderID
	 */
	public int getSenderID() {
		return senderID;
	}

	/**
	 * @param senderID
	 *            the senderID to set
	 */
	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	/**
	 * @return the receiverID
	 */
	public int getReceiverID() {
		return receiverID;
	}

	/**
	 * @param receiverID
	 *            the receiverID to set
	 */
	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}

	/**
	 * @return the sendAddress
	 */
	public String getSendAddress() {
		return sendAddress;
	}

	/**
	 * @param sendAddress
	 *            the sendAddress to set
	 */
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	/**
	 * @return the receiveAddress
	 */
	public String getReceiveAddress() {
		return receiveAddress;
	}

	/**
	 * @param receiveAddress
	 *            the receiveAddress to set
	 */
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	/**
	 * @return the acceptDate
	 */
	public Date getAcceptDate() {
		return acceptDate;
	}

	/**
	 * @param acceptDate
	 *            the acceptDate to set
	 */
	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

}
