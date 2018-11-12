/**
 * 
 */
package application.pojo;

/**
 * Ê£?ËßÜÂèçÈ¶àÂçï
 *
 * @author ly
 *
 *         2018Âπ?6Êú?20Êó•‰∏ãÂç?5:13:33
 */
public class ViewFeedbackForm {

	private int viewFeedbackFormID;
	private String orderID;
	private String warehouseLocation;
	private String orderState;
	private String viewDate;
	private String remark;

	/**
	 * 
	 */
	public ViewFeedbackForm() {
		super();
	}

	/**
	 * @param viewFeedbackFormID
	 * @param orderID
	 * @param warehouseLocation
	 * @param orderState
	 * @param viewDate
	 */
	public ViewFeedbackForm(int viewFeedbackFormID, String orderID, String warehouseLocation, String orderState,
			String viewDate) {
		super();
		this.viewFeedbackFormID = viewFeedbackFormID;
		this.orderID = orderID;
		this.warehouseLocation = warehouseLocation;
		this.orderState = orderState;
		this.viewDate = viewDate;
	}

	/**
	 * @param viewFeedbackFormID
	 * @param orderID
	 * @param warehouseLocation
	 * @param orderState
	 * @param viewDate
	 * @param remark
	 */
	public ViewFeedbackForm(int viewFeedbackFormID, String orderID, String warehouseLocation, String orderState,
			String viewDate, String remark) {
		super();
		this.viewFeedbackFormID = viewFeedbackFormID;
		this.orderID = orderID;
		this.warehouseLocation = warehouseLocation;
		this.orderState = orderState;
		this.viewDate = viewDate;
		this.remark = remark;
	}

	/**
	 * @return the viewFeedbackFormID
	 */
	public int getviewFeedbackFormID() {
		return viewFeedbackFormID;
	}

	/**
	 * @param viewFeedbackFormID
	 *            the viewFeedbackFormID to set
	 */
	public void setviewFeedbackFormID(int viewFeedbackFormID) {
		this.viewFeedbackFormID = viewFeedbackFormID;
	}

	/**
	 * @return the orderID
	 */
	public String getOrderID() {
		return orderID;
	}

	/**
	 * @param orderID
	 *            the orderID to set
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	/**
	 * @return the warehouseLocation
	 */
	public String getwarehouseLocation() {
		return warehouseLocation;
	}

	/**
	 * @param warehouseLocation
	 *            the warehouseLocation to set
	 */
	public void setwarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	/**
	 * @return the orderState
	 */
	public String getOrderState() {
		return orderState;
	}

	/**
	 * @param orderState
	 *            the orderState to set
	 */
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	/**
	 * @return the viewDate
	 */
	public String getviewDate() {
		return viewDate;
	}

	/**
	 * @param viewDate
	 *            the viewDate to set
	 */
	public void setviewDate(String viewDate) {
		this.viewDate = viewDate;
	}

	/**
	 * @return the warehouseLocation
	 */
	public String getWarehouseLocation() {
		return warehouseLocation;
	}

	/**
	 * @param warehouseLocation
	 *            the warehouseLocation to set
	 */
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
