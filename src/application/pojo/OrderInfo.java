/**
 * 
 */
package application.pojo;

/**
 * 服务员看到的订单实体(视图)
 *
 * @author ly
 *
 *         2018�?6�?22日下�?3:14:02
 */
public class OrderInfo {

	private int orderID;
	private String senderName;
	private String senderPhoneNumber;
	private String receiverName;
	private String receiverPhoneNumber;
	private String startAddress;
	private String endAddress;

	/**
	 * 
	 */
	public OrderInfo() {
		super();
	}

	/**
	 * @param orderID
	 * @param senderName
	 * @param senderPhoneNumber
	 * @param receiverName
	 * @param receiverPhoneNumber
	 * @param startAddress
	 * @param endAddress
	 */
	public OrderInfo(int orderID, String senderName, String senderPhoneNumber, String receiverName,
			String receiverPhoneNumber, String startAddress, String endAddress) {
		super();
		this.orderID = orderID;
		this.senderName = senderName;
		this.senderPhoneNumber = senderPhoneNumber;
		this.receiverName = receiverName;
		this.receiverPhoneNumber = receiverPhoneNumber;
		this.startAddress = startAddress;
		this.endAddress = endAddress;
	}

	/**
	 * @return the orderID
	 */
	public int getorderID() {
		return orderID;
	}

	/**
	 * @param orderID
	 *            the orderID to set
	 */
	public void setorderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * @param senderName
	 *            the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return the senderPhoneNumber
	 */
	public String getSenderPhoneNumber() {
		return senderPhoneNumber;
	}

	/**
	 * @param senderPhoneNumber
	 *            the senderPhoneNumber to set
	 */
	public void setSenderPhoneNumber(String senderPhoneNumber) {
		this.senderPhoneNumber = senderPhoneNumber;
	}

	/**
	 * @return the receiverName
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 * @param receiverName
	 *            the receiverName to set
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	/**
	 * @return the receiverPhoneNumber
	 */
	public String getReceiverPhoneNumber() {
		return receiverPhoneNumber;
	}

	/**
	 * @param receiverPhoneNumber
	 *            the receiverPhoneNumber to set
	 */
	public void setReceiverPhoneNumber(String receiverPhoneNumber) {
		this.receiverPhoneNumber = receiverPhoneNumber;
	}

	/**
	 * @return the startAddress
	 */
	public String getStartAddress() {
		return startAddress;
	}

	/**
	 * @param startAddress
	 *            the startAddress to set
	 */
	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	/**
	 * @return the endAddress
	 */
	public String getEndAddress() {
		return endAddress;
	}

	/**
	 * @param endAddress
	 *            the endAddress to set
	 */
	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

}
