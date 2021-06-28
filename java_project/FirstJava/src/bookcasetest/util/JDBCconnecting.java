package bookcasetest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnecting {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "USER1";
	private static String password = "tiger";
	
	private JDBCconnecting() {}
	private static JDBCconnecting jdbc = new JDBCconnecting();
	public static JDBCconnecting getInstence() {
		return jdbc;
	}
	
	public static Connection connecting() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
