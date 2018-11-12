/**
 * 
 */
package application.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Java与MySQL数据�?
 *
 * @author ly
 *
 *         2018�?6�?18日下�?3:30:32
 */
public class DBUtil {
	// 定义连接�?�?的字符串
	private static String user;
	private static String pwd;
	private static String url;

	// 创建�?个数据库连接
	private static Connection conn = null;
	// 创建�?个预编译对象
	private static PreparedStatement ps = null;
	// 创建�?个结果对�?
	private static ResultSet rs = null;

	/**
	 * Constructor
	 */
	public DBUtil() {

	}

	static {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			InputStream is = DBUtil.class.getResourceAsStream("./db.properties");// db.properties是用户配置文�?
			Properties prop = new Properties();
			prop.load(is);
			user = prop.getProperty("user");
			pwd = prop.getProperty("password");
			url = prop.getProperty("url");
			// conn = DriverManager.getConnection(url, user, pwd);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到ResultSet对象
	 * 
	 * @param sql
	 * @return
	 */
	public static ResultSet getResultSet(String sql) {
		conn = getConn();

		try {
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * 查询数据
	 * 
	 * @param sql
	 */
	public static void selectData(String sql) {
		conn = getConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int age = rs.getInt("age");

				System.out.println(id + "," + username + "," + password + "," + age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ReleaseResourse();
		}
	}

	/**
	 * 连接数据�?
	 * 
	 * @return
	 */
	public static Connection getConn() {
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 释放资源
	 */
	public static void ReleaseResourse() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
