package nuc.edu.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/online-edu";
	public static final String DBUSER="root";
	public static final String DBPASS="15735659458zxc";
	
	static Connection conn = null;
	
	public static Connection getConn() {
		
		try{
			
			Class.forName( DBDRIVER );
			
			conn = DriverManager.getConnection( DBURL , DBUSER , DBPASS );
			
		}catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return conn;
		
	}
	
}
