package nuc.edu.dbbase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbBase {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/online-edu";
	public static final String DBUSER="root";
	public static final String DBPASS="15735659458zxc";
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			
		} catch (Exception e) {
			System.out.println("连接数据库失败！");
		}
		return conn;
	}
}
