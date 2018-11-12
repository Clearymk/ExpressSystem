/**
 * 
 */
package application.pojo;

/**
 * 调度实体, 视图
 *
 * @author ly
 *
 *         2018�?6�?22日下�?2:05:15
 */
public class DispatchInfo {

	private int expressID;
	private int conveyanceID;
	private String startAddress;
	private String endAddress;
	private int dispatchcenterID;

	/**
	 * 
	 */
	public DispatchInfo() {
		super();
	}

	/**
	 * @param expressID
	 * @param conveyanceID
	 * @param startAddress
	 * @param endAddress
	 * @param dispatchcenterID
	 */
	public DispatchInfo(int expressID, int conveyanceID, String startAddress, String endAddress,
			int dispatchcenterID) {
		super();
		this.expressID = expressID;
		this.conveyanceID = conveyanceID;
		this.startAddress = startAddress;
		this.endAddress = endAddress;
		this.dispatchcenterID = dispatchcenterID;
	}

	/**
	 * @return the expressID
	 */
	public int getExpressID() {
		return expressID;
	}

	/**
	 * @param expressID
	 *            the expressID to set
	 */
	public void setExpressID(int expressID) {
		this.expressID = expressID;
	}

	/**
	 * @return the conveyanceID
	 */
	public int getConveyanceID() {
		return conveyanceID;
	}

	/**
	 * @param conveyanceID
	 *            the conveyanceID to set
	 */
	public void setConveyanceID(int conveyanceID) {
		this.conveyanceID = conveyanceID;
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

	/**
	 * @return the dispatchcenterID
	 */
	public int getDispatchcenterID() {
		return dispatchcenterID;
	}

	/**
	 * @param dispatchcenterID
	 *            the dispatchcenterID to set
	 */
	public void setDispatchcenterID(int dispatchcenterID) {
		this.dispatchcenterID = dispatchcenterID;
	}

}
