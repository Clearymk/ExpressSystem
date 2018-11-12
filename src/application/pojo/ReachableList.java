/**
 * 
 */
package application.pojo;

import java.sql.Date;

/**
 * ÂèØËææË°?
 *
 * @author ly
 *
 *         2018Âπ?6Êú?21Êó•‰∏ãÂç?5:30:09
 */
public class ReachableList {

	private String reachableListID;
	private String startRepositoryID;
	private String endRepositoryID;
	private Date predictTime;
	private float distance;
	private float transportCost;

	/**
	 * 
	 */
	public ReachableList() {
		super();
	}

	/**
	 * @param reachableListID
	 * @param startRepositoryID
	 * @param endRepositoryID
	 * @param predictTime
	 * @param distance
	 * @param transportCost
	 */
	public ReachableList(String reachableListID, String startRepositoryID, String endRepositoryID, Date predictTime,
			float distance, float transportCost) {
		super();
		this.reachableListID = reachableListID;
		this.startRepositoryID = startRepositoryID;
		this.endRepositoryID = endRepositoryID;
		this.predictTime = predictTime;
		this.distance = distance;
		this.transportCost = transportCost;
	}

	/**
	 * @return the reachableListID
	 */
	public String getReachableListID() {
		return reachableListID;
	}

	/**
	 * @param reachableListID
	 *            the reachableListID to set
	 */
	public void setReachableListID(String reachableListID) {
		this.reachableListID = reachableListID;
	}

	/**
	 * @return the startRepositoryID
	 */
	public String getStartRepositoryID() {
		return startRepositoryID;
	}

	/**
	 * @param startRepositoryID
	 *            the startRepositoryID to set
	 */
	public void setStartRepositoryID(String startRepositoryID) {
		this.startRepositoryID = startRepositoryID;
	}

	/**
	 * @return the endRepositoryID
	 */
	public String getEndRepositoryID() {
		return endRepositoryID;
	}

	/**
	 * @param endRepositoryID
	 *            the endRepositoryID to set
	 */
	public void setEndRepositoryID(String endRepositoryID) {
		this.endRepositoryID = endRepositoryID;
	}

	/**
	 * @return the predictTime
	 */
	public Date getPredictTime() {
		return predictTime;
	}

	/**
	 * @param predictTime
	 *            the predictTime to set
	 */
	public void setPredictTime(Date predictTime) {
		this.predictTime = predictTime;
	}

	/**
	 * @return the distance
	 */
	public float getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(float distance) {
		this.distance = distance;
	}

	/**
	 * @return the transportCost
	 */
	public float getTransportCost() {
		return transportCost;
	}

	/**
	 * @param transportCost
	 *            the transportCost to set
	 */
	public void setTransportCost(float transportCost) {
		this.transportCost = transportCost;
	}

}
