/**
 * 
 */
package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.dao.DBUtil;
import application.pojo.Driver;
import application.pojo.LoginUser;
import application.pojo.Manager;
import application.pojo.User;
import application.pojo.Viewer;
import application.pojo.Waiter;

/**
 * 实现登录逻辑
 *
 * @author ly
 *
 *         2018�?6�?18日下�?4:38:31
 */
public class Login {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * 判断用户的类�?
	 * 
	 * @param sql
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean judgeUserType(String sql, String username, String password) throws Exception {

		// 数据库连�?
		conn = DBUtil.getConn();

		// 预编译sql语句
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		// 执行sql语句
		rs = ps.executeQuery();

		if (rs.next()) {
			DBUtil.ReleaseResourse();
			return true;
		} else {
			DBUtil.ReleaseResourse();
			return false;
		}
	}

	/**
	 * 得到用户的ID
	 * 
	 * @param sql
	 * @param item
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public int getUserID(String sql, String item, String username, String password) throws Exception {
		// 数据库连�?
		conn = DBUtil.getConn();

		// 预编译sql语句
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		// 执行sql语句
		rs = ps.executeQuery();
		int userID = 0;

		// 获取相关属�??
		if (rs.next()) {
			userID = rs.getInt(item);
		}

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return userID;
	}

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public LoginUser login(String username, String password) throws Exception {

		// sql语句
		String userSQL = "select * from user where username=? and password=?";
		String waiterSQL = "select * from waiter where username=? and password=?";
		String driverSQL = "select * from driver where username=? and password=?";
		String viewerSQL = "select * from viewer where username=? and password=?";
		String managerSQL = "select * from manager where username=? and password=?";

		// 判断用户类型
		boolean isUser = judgeUserType(userSQL, username, password);
		boolean isWaiter = judgeUserType(waiterSQL, username, password);
		boolean isDriver = judgeUserType(driverSQL, username, password);
		boolean isViewer = judgeUserType(viewerSQL, username, password);
		boolean isManager = judgeUserType(managerSQL, username, password);
		
		
		if (isUser) {
			// 获取用户ID
			int userID = getUserID(userSQL, "UserID", username, password);
			return new User(userID);
		} else if (isWaiter) {
			int waiterID = getUserID(waiterSQL, "StaffID", username, password);
			return new Waiter(waiterID);
		} else if (isDriver) {
			int driverID = getUserID(driverSQL, "StaffID", username, password);
			return new Driver(driverID);
		} else if (isViewer) {
			int viewerID = getUserID(viewerSQL, "StaffID", username, password);
			return new Viewer(viewerID);
		} else if (isManager) {
			int managerID = getUserID(managerSQL, "StaffID", username, password);
			return new Manager(managerID);
		} else {
			throw new Exception("用户名或密码错误...");
		}
	}

}
