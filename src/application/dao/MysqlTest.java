/**
 * 
 */
package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 测试Java与MySQL数据库的连接
 *
 * @author ly
 *
 *         2018年6月17日下午3:52:39
 */
public class MysqlTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null; // 预编译的sql对象
		ResultSet rs = null;

		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.得到连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/data_test?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root", "root");
			// 3.创建sql对象
			ps = conn.prepareStatement("select * from t_user");
			// 4.执行
			rs = ps.executeQuery();
			// 循环取出结果集中的内容
			while (rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ps = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}

		}
	}
}
