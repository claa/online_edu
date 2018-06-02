package nuc.edu.dao.forum;

import nuc.edu.conn.Conn;
import nuc.edu.entity.Student;
import java.sql.*;
public class StudentDaoImpl implements StudentDao{
	   public static Connection conn=Conn.getConn();
	public Student selectStudentById(int s_id) {
		ResultSet rs=null;
		String sql="select * from student  where s_id=?";
		 Student s=new Student();
		try{
			 PreparedStatement pst=conn.prepareStatement(sql);
			 pst.setInt(1, s_id);
			 rs=pst.executeQuery();
			 if(rs.next()){
				  
				   s.setS_major(rs.getInt("s_major"));
				   
				   s.setS_id(rs.getInt("s_id"));
				   s.setS_no(rs.getString("s_no"));
				   s.setS_password(rs.getString("s_password"));
				
				   s.setS_sign(rs.getInt("s_sign"));
				   s.setS_username(rs.getString("s_username"));
			 }
		}catch(Exception e){
			  e.printStackTrace();
		}
		return s;
	}

}
