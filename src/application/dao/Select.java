/**
 * 
 */
package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import application.pojo.ChargeInfo;
import application.pojo.DispatchInfo;
import application.pojo.Driver;
import application.pojo.Employee;
import application.pojo.OrderInfo;
import application.pojo.ViewFeedbackForm;
import application.pojo.Viewer;
import application.pojo.Waiter;

/**
 * 查询
 *
 * @author ly
 *
 *         2018�?6�?20日下�?5:19:04
 */
public class Select {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * 通过仓库号查询仓库地�?
	 * 
	 * @param warehouseID
	 * @return
	 * @throws Exception
	 */
	public String selectWarehouseLocationByWarehouseID(String warehouseID) throws Exception {
		String warehouseLocation = null;

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select WarehouseLocation from warehouse where WarehouseID = ?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, warehouseID);

		// 执行查询语句
		rs = ps.executeQuery();

		if (rs.next()) {
			warehouseLocation = rs.getString("WarehouseLocation");
			System.out.println(warehouseLocation);
		}

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return warehouseLocation;
	}

	/**
	 * 通过订单号查询订�?
	 * 
	 * @param orderID
	 * @return
	 * @throws Exception
	 */
	public ViewFeedbackForm selectSurveyFeedbackFormByOrderID(String orderID) throws Exception {

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select * from viewfeedback where OrderID = ?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, orderID);

		// 执行查询语句
		rs = ps.executeQuery();

		// 获得相关属�??
		int viewFeedbackFormID = 0;
		String warehouseID = null;
		String orderState = null;
		String viewDate = null;
		String remark = null;
		if (rs.next()) {
			viewFeedbackFormID = rs.getInt("FeedbackID");
			warehouseID = rs.getString("WarehouseID");
			orderState = rs.getString("OrderState");
			viewDate = rs.getString("SurveyDate");
			remark = rs.getString("Remark");
		}

		// 根据仓库ID查询仓库地址
		String warehouseLocation = selectWarehouseLocationByWarehouseID(warehouseID);
		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return new ViewFeedbackForm(viewFeedbackFormID, orderID, warehouseLocation, orderState, viewDate, remark);
	}

	/**
	 * 根据仓库地址查询仓库ID
	 * 
	 * @param repositoryLocation
	 * @return
	 * @throws Exception
	 */
	public int selectRepositoryIDByLocation(String repositoryLocation) throws Exception {

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select WarehouseID from warehouse where WarehouseLocation = ?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, repositoryLocation);

		// 执行查询语句
		rs = ps.executeQuery();

		int repositoryID = 0;
		// 获得相关属�??
		if (rs.next()) {
			repositoryID = rs.getInt("WarehouseID");
		}

		return repositoryID;
	}

	/**
	 * 通过可达表中的起始地�?与目标地�?查询运输的损�?
	 * 
	 * @param startRepositoryLocation
	 * @param endRepositoryLocation
	 * @return
	 * @throws Exception
	 */
	public ChargeInfo selectChargeInfoByReachableList(String startRepositoryLocation, String endRepositoryLocation)
			throws Exception {
		// 与数据库建立连接
		conn = DBUtil.getConn();

		// 查询仓库ID
		int startRepositoryID = selectRepositoryIDByLocation(startRepositoryLocation);
		int endRepositoryID = selectRepositoryIDByLocation(endRepositoryLocation);

		// sql语句
		String sql = "SELECT TransportCost, PredictTime FROM reachabletable WHERE StartWarehouseID = ? AND EndWarehouseID = ?";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, startRepositoryID);
		ps.setInt(2, endRepositoryID);

		// 执行查询语句
		rs = ps.executeQuery();

		// 获得相关属�??
		float transportCost = 0;
		float predictTime = 0;
		ChargeInfo info = null;
		if (rs.next()) {
			transportCost = rs.getFloat("TransportCost");
			predictTime = rs.getFloat("PredictTime");

			info = new ChargeInfo(transportCost, predictTime);
		}

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return info;
	}

	/**
	 * 通过用户姓名查询用户ID
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int selectUserIDByName(String name) throws Exception {

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select UserID from user where Name = ?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, name);

		// 执行查询语句
		rs = ps.executeQuery();

		// 获得相关属�??
		int userID = 0;
		if (rs.next()) {
			userID = rs.getInt("UserID");
		}

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return userID;
	}

	/**
	 * 查询生成的订单号
	 * 
	 * @return
	 * @throws Exception
	 */
	public int selectOrderID() throws Exception {

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "SELECT MAX(OrderID) FROM orderform";

		ps = conn.prepareStatement(sql);

		// 执行查询语句
		rs = ps.executeQuery();
		int orderID = 0;
		// 获得相关属�??
		if (rs.next()) {
			orderID = rs.getInt("max(OrderID)");
		}

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return orderID;
	}

	/**
	 * 生成订单
	 * 
	 * @param senderName
	 * @param receiverName
	 * @param sendAddress
	 * @param receiveAddress
	 * @return
	 * @throws Exception
	 */
	public int createOrderBySenderReceiverInfo(String senderName, String receiverName, String sendAddress,
			String receiveAddress, LocalDate acceptDate) throws Exception {

		// 通过用户姓名查询用户ID
		int senderID = selectUserIDByName(senderName);
		int receiverID = selectUserIDByName(receiverName);

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "insert into orderform(SenderID, ReceiverID, SendAddress, ReceiveAddress, AcceptDate) values(?, ?, ?, ?, ?)";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, senderID);
		ps.setInt(2, receiverID);
		ps.setString(3, sendAddress);
		ps.setString(4, receiveAddress);
		ps.setDate(5, Date.valueOf(acceptDate));

		// 执行插入语句
		ps.execute();

		// 关闭数据库连接
		DBUtil.ReleaseResourse();

		// 获得新生成的订单接
		int orderID = selectOrderID();

		return orderID;
	}

	/**
	 * 通过仓库号查询仓库地�?
	 * 
	 * @param warehouseID
	 * @return
	 * @throws Exception
	 */
	public String selectAddressByRepositoryID(int warehouseID) throws Exception {

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select WarehouseLocation from warehouse where WarehouseID = ?";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, warehouseID);

		// 执行查询语句
		rs = ps.executeQuery();

		String address = null;
		// 获得相关属�??
		if(rs.next()) {
			 address = rs.getString("WarehouseLocation");
		}

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return address;
	}

	public List<OrderInfo> selectOrderInfoByStaffID(int staffID) throws Exception {
		List<OrderInfo> orderList = new ArrayList<>();

		conn = DBUtil.getConn();

		String sql = "SELECT * FROM orderform WHERE StaffID = ?";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, staffID);

		rs = ps.executeQuery();

		while (rs.next()) {
			OrderInfo orderInfo = new OrderInfo();

			orderInfo.setorderID(rs.getInt("OrderID"));
			orderInfo.setStartAddress(rs.getString("SendAddress"));
			orderInfo.setEndAddress(rs.getString("ReceiveAddress"));

			int senderID = rs.getInt("SenderID");
			int receiverID = rs.getInt("ReceiverID");

			List<String> senderInfo = selectNameAndPhoneNumberByUserID(senderID);
			List<String> receiverInfo = selectNameAndPhoneNumberByUserID(receiverID);

			orderInfo.setSenderName(senderInfo.get(0));
			orderInfo.setSenderPhoneNumber(senderInfo.get(1));
			orderInfo.setReceiverName(receiverInfo.get(0));
			orderInfo.setReceiverPhoneNumber(receiverInfo.get(1));

			orderList.add(orderInfo);

		}

		return orderList;
	}

	/**
	 * 通过路线分配表查询地�?
	 * 
	 * @param routerListID
	 * @return
	 * @throws Exception
	 */
	public List<String> selectAddressByRouterListID(int routerListID) throws Exception {

		List<String> addressList = new ArrayList<>();

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select StartWarehouseID, TargetWarehouseID from routertable where RouterListID = ?";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, routerListID);

		int startRepositoryID = 0;
		int endRepositoryID = 0;
		// 执行查询语句
		rs = ps.executeQuery();

		if (rs.next()) {
			startRepositoryID = rs.getInt("StartWarehouseID");
			endRepositoryID = rs.getInt("TargetWarehouseID");
		}

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		// 通过仓库编号查询仓库地址
		String startAddress = selectAddressByRepositoryID(startRepositoryID);
		String endAddress = selectAddressByRepositoryID(endRepositoryID);

		addressList.add(startAddress);
		addressList.add(endAddress);

		return addressList;
	}

	/**
	 * 通过员工ID(司机)查询调度信息
	 * 
	 * @param staffID
	 * @return
	 * @throws Exception
	 */
	public DispatchInfo selectDispatchInfoByStaffID(int staffID) throws Exception {

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select * from dispatch where StaffID = ?";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, staffID);

		// 执行查询语句
		rs = ps.executeQuery();
		int expressID = 0;
		int conveyanceID = 0;
		int routerListID = 0;
		int dispatchCenterID = 0;

		if (rs.next()) {
			expressID = rs.getInt("ExpressID");
			routerListID = rs.getInt("RouterListID");
			conveyanceID = rs.getInt("ConveyanceID");
			dispatchCenterID = rs.getInt("DispatchCenterID");
		}

		// 通过路由分配表查询出发地与目的地
		List<String> addressList = selectAddressByRouterListID(routerListID);

		String startAddress = addressList.get(0);
		String endAddress = addressList.get(1);

		return new DispatchInfo(expressID, conveyanceID, startAddress, endAddress, dispatchCenterID);
	}

	/**
	 * 判断此订单是否由此用户发�?
	 * 
	 * @param userID
	 * @param orderID
	 * @return
	 * @throws Exception
	 */
	public boolean isOrderMapUser(int userID, int orderID) throws Exception {

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select SenderID from orderform where OrderID = ?";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, orderID);

		// 执行查询语句
		rs = ps.executeQuery();

		// 获得相关属�??
		int selectUserID = 0;

		if (rs.next()) {
			selectUserID = rs.getInt("SenderID");
			System.out.println(selectUserID);
			System.out.println(userID);
		}
		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		if (selectUserID != userID) {
			return false;
		}

		return true;
	}

	/**
	 * 通过用户反馈的信息创建用户反馈单
	 * 
	 * @param userID
	 * @param orderID
	 * @param userFeedbackType
	 * @param userFeedbackTheme
	 * @param userFeedbackContent
	 * @return
	 * @throws Exception
	 */
	public boolean createUserFeedbackFormByFeedbackInfo(int userID, int orderID, String userFeedbackType,
			String userFeedbackTheme, String userFeedbackContent) throws Exception {

		if (!isOrderMapUser(userID, orderID)) {
			return false;
		}

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "insert into userfeedback(UserID, OrderID, FeedbackType, FeedbackTheme, FeedbackContent) values(?, ?, ?, ?, ?)";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ps.setInt(2, orderID);
		ps.setString(3, userFeedbackType);
		ps.setString(4, userFeedbackTheme);
		ps.setString(5, userFeedbackContent);

		// 执行插入语句
		ps.execute();

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return true;
	}

	/**
	 * 通过用户的ID查询用户的姓名和用户的手机号
	 * 
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	public List<String> selectNameAndPhoneNumberByUserID(int userID) throws Exception {
		List<String> nameAndPhoneNum = new ArrayList<>();

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select Name, UserPhoneNumber from user where UserID = ?";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);

		// 执行查询语句
		rs = ps.executeQuery();
		String name = "";
		String userPhoneNumber = "";

		// 获得相关属�??
		if (rs.next()) {
			name = rs.getString("Name");
			userPhoneNumber = rs.getString("UserPhoneNumber");
		}

		// 关闭数据库连�?
		nameAndPhoneNum.add(name);
		nameAndPhoneNum.add(userPhoneNumber);

		return nameAndPhoneNum;
	}

	/**
	 * 通过订单ID查询订单信息
	 * 
	 * @param orderID
	 * @return OrderInfo
	 * @throws Exception
	 */
	public OrderInfo selectOrderInfoByOrderID(int orderID) throws Exception {
		List<String> senderList = new ArrayList<>();
		List<String> receiverList = new ArrayList<>();

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select * from orderform where OrderID = ?";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, orderID);

		// 执行查询语句
		rs = ps.executeQuery();

		// 获得相关属�??
		int senderID = rs.getInt("SenderID");
		int receiverID = rs.getInt("ReceiverID");
		String sendAddress = rs.getString("SendAddress");
		String receiveAddress = rs.getString("ReceiveAddress");

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		// 通过用户ID查询用户的姓名和手机�?
		senderList = selectNameAndPhoneNumberByUserID(senderID);
		receiverList = selectNameAndPhoneNumberByUserID(receiverID);

		String senderName = senderList.get(0);
		String senderPhoneNumber = senderList.get(1);
		String receiverName = receiverList.get(0);
		String receiverPhoneNumber = receiverList.get(1);

		return new OrderInfo(orderID, senderName, senderPhoneNumber, receiverName, receiverPhoneNumber, sendAddress,
				receiveAddress);
	}

	/**
	 * 生成�?视反馈单
	 * 
	 * @param orderID
	 * @param warehouseID
	 * @param orderState
	 * @param remark
	 * @return
	 * @throws Exception
	 */
	public boolean createViewFeedback(int orderID, int warehouseID, int staffID, String orderState, String remark)
			throws Exception {
		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "insert into viewfeedback(OrderID, WarehouseID, StaffID, OrderState, Remark) values(?, ?, ?, ?, ?)";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, orderID);
		ps.setInt(2, warehouseID);
		ps.setInt(3, staffID);
		ps.setString(4, orderState);
		ps.setString(5, remark);

		// 执行插入语句
		ps.execute();

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return true;
	}

	/**
	 * 查询管理员的�?有员�?
	 * 
	 * @param managerID
	 * @return
	 * @throws Exception
	 */
	public List<Employee> selectEmployeeManagedByManager(int managerID) throws Exception {
		List<Employee> employee = new ArrayList<>();
		String[] types = { "waiter", "driver", "viewer" };

		// 与数据库建立连接
		conn = DBUtil.getConn();

		for (String staffType : types) {

			// sql语句
			String sql = "select * from " + staffType + " where Man_StaffID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, managerID);
			// 执行查询语句
			rs = ps.executeQuery();
			// 获得相关属�??
			while (rs.next()) {
				int staffID = rs.getInt("StaffID");
				String staffName = rs.getString("StaffName");
				Date staffBirthday = rs.getDate("StaffBirthday");
				String staffGender = rs.getString("StaffGender");
				String staffPhoneNumber = rs.getString("StaffPhoneNumber");
				String staffAddress = rs.getString("StaffAddress");
				float staffSalary = rs.getFloat("StaffSalary");
				if ("waiter".equals(staffType)) {
					Waiter w = new Waiter(staffID, staffName, staffBirthday, staffAddress, staffGender,
							staffPhoneNumber, staffSalary);
					employee.add(w);
				} else if ("viewer".equals(staffType)) {
					Viewer v = new Viewer(staffID, staffName, staffBirthday, staffAddress, staffGender,
							staffPhoneNumber, staffSalary);
					employee.add(v);
				} else if ("driver".equals(staffType)) {
					Driver d = new Driver(staffID, staffName, staffBirthday, staffAddress, staffGender,
							staffPhoneNumber, staffSalary);
					employee.add(d);
				}

			}
		}

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return employee;

	}

	/**
	 * 创建员工
	 * 
	 * @param staffName
	 * @param staffGender
	 * @param staffPhoneNumber
	 * @param type
	 * @param staffSalary
	 * @param staffBirthday
	 * @return
	 * @throws Exception
	 */
	public boolean createEmployee(String staffName, String staffGender, String staffPhoneNumber, String staffType,
			float staffSalary, Date staffBirthday) throws Exception {
		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "insert into " + staffType
				+ "(StaffName, StaffBirthday, StaffGender, StaffPhoneNumber, StaffSalary) values(?, ?, ?, ?, ?)";

		ps = conn.prepareStatement(sql);
		ps.setString(1, staffName);
		ps.setDate(2, staffBirthday);
		ps.setString(3, staffGender);
		ps.setString(4, staffPhoneNumber);
		ps.setFloat(5, staffSalary);

		// 执行插入语句
		ps.execute();

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return true;
	}

	/**
	 * 更新员工信息
	 * 
	 * @param staffID
	 * @param staffName
	 * @param staffGender
	 * @param staffPhoneNumber
	 * @param staffType
	 * @param staffSalary
	 * @param staffBirthday
	 * @return
	 * @throws Exception
	 */
	public boolean updateEmployee(int staffID, String staffName, String staffGender, String staffPhoneNumber,
			String staffType, float staffSalary, Date staffBirthday, String staffAddress) throws Exception {
		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "update " + staffType + " set "
				+ "StaffName=?, StaffBirthday=?, StaffGender=?, StaffPhoneNumber=?, StaffSalary=?, StaffAddress=? where staffID=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, staffName);
		ps.setDate(2, staffBirthday);
		ps.setString(3, staffGender);
		ps.setString(4, staffPhoneNumber);
		ps.setFloat(5, staffSalary);
		ps.setString(6, staffAddress);
		ps.setInt(7, staffID);

		// 执行插入语句
		ps.execute();

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return true;
	}

	/**
	 * 删除员工信息
	 * 
	 * @param staffID
	 * @param staffType
	 * @return
	 * @throws Exception
	 */
	public boolean deleteEmployee(int staffID, String staffType) throws Exception {

		// 与数据库建立连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "delete from " + staffType + " where StaffID=?";

		ps = conn.prepareStatement(sql);
		ps.setInt(1, staffID);

		// 执行删除语句
		ps.execute();

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return true;
	}
}
