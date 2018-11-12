/**
 * 
 */
package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 实现注册逻辑
 *
 * @author ly
 *
 *         2018�?6�?20日下�?2:40:47
 */
public class Register {

	/**
	 * register
	 * 
	 * @param username
	 * @param password
	 * @param age
	 * @throws Exception
	 */
	public boolean register(String username, String password, String repassword, String phoneNumber,
			String emailAddress) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;

		// 数据库连�?
		conn = DBUtil.getConn();

		// 判断是否有相同的用户�?
		boolean isRename = isRename(username, conn);

		if (isRename) {
			System.out.println("该用户名已经存在...");
			return false;
		}

		// sql语句
		String sql = "insert into t_user(Username, Password, UserPhoneNumber, UserEmailAddress) values(?, ?, ?, ?)";

		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, phoneNumber);
		ps.setString(4, emailAddress);

		// 执行插入语句
		ps.execute();

		System.out.println("注册成功...");

		// 关闭数据库连�?
		DBUtil.ReleaseResourse();

		return true;
	}

	public boolean isRename(String username, Connection conn) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		// sql语句
		String sql = "select username from t_user where username=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		// 执行
		rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		}

		return false;
	}
}
