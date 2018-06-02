package nuc.edu.coon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
		public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
		public static final String DBURL="jdbc:mysql://localhost:3306/online-edu";
		public static final String DBUSER="root";
		public static final String DBPASS="15735659458zxc";
       private static Connection coon=null;
       
            public static Connection getCoon() {
            	
            	try {
					Class.forName(DBDRIVER);
					coon=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	return coon;
            }
}
