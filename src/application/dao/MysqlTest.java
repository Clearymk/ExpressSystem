/**
 * 
 */
package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ����Java��MySQL���ݿ������
 *
 * @author ly
 *
 *         2018��6��17������3:52:39
 */
public class MysqlTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null; // Ԥ�����sql����
		ResultSet rs = null;

		try {
			// 1.��������
			Class.forName("com.mysql.jdbc.Driver");
			// 2.�õ�����
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/data_test?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root", "root");
			// 3.����sql����
			ps = conn.prepareStatement("select * from t_user");
			// 4.ִ��
			rs = ps.executeQuery();
			// ѭ��ȡ��������е�����
			while (rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
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
